package com.example.newsuktech.di

import android.app.Application
import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.utilities.Constants.Companion.COIN_PAPRIKA_BASE_URL
import com.example.newsuktech.App
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApi(gson: Gson): Api {
        val baseUrl = COIN_PAPRIKA_BASE_URL
        val client = getOkHttpClient()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(Api::class.java)
    }

    private fun addLoggingInterceptor(httpClientBuilder: OkHttpClient.Builder) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)

        val builder = OkHttpClient.Builder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(1, TimeUnit.MINUTES)
        builder.writeTimeout(30, TimeUnit.SECONDS)

        addLoggingInterceptor(builder)
        builder.connectionSpecs(
            listOf(
                ConnectionSpec.MODERN_TLS,
                ConnectionSpec.COMPATIBLE_TLS,
                ConnectionSpec.CLEARTEXT
            )
        )

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApp(app: Application): App {
        return app as App
    }

    //region handlers
    @Singleton
    @Provides
    fun provideApiResponseHandler(): ApiResponseHandler<*> {
        return ApiResponseHandler<Any>()
    }
    //endregion handlers

}