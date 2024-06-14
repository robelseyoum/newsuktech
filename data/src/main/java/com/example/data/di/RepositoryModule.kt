package com.example.data.di

import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.api.response.CoinResponse
import com.example.data.repository.CoinsRepositoryImpl
import com.example.domain.repository.CoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinsRepository(
        api: Api,
        apiResponseHandler: ApiResponseHandler<CoinResponse>
    ): CoinsRepository {
        return CoinsRepositoryImpl(api, apiResponseHandler)
    }
}