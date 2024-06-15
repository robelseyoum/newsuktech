package com.example.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.api.response.CoinResponse
import com.example.data.mapper.mapToDomain
import com.example.newsuktech.util.MainDispatcherRule
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response


@ExperimentalCoroutinesApi
class CoinDetailRepositoryImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @get:Rule
    val coroutineRule = MainDispatcherRule()


    private lateinit var api: Api
    private lateinit var apiResponseHandler: ApiResponseHandler<List<CoinResponse>>
    private lateinit var repository: CoinDetailRepositoryImpl

    @Before
    fun setUp() {
        api = mockk()
        apiResponseHandler = mockk()
        repository = CoinDetailRepositoryImpl(api, apiResponseHandler)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test get coin detail returns coin data`() = runBlocking {
        val coinResponse =
            CoinResponse(
                "bitcoin",
                "Bitcoin",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            )

        val coinData = coinResponse.mapToDomain()

        coEvery { api.getCoinDetail("bitcoin") } returns Response.success(coinResponse)

        coEvery { apiResponseHandler.handleApiCall<CoinResponse>(any()) } returns flowOf(
            coinResponse
        )

        val result = repository.getCoin("bitcoin").first()

        Assert.assertEquals(coinData, result)
    }

}