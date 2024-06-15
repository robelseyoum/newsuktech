package com.example.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.api.response.CoinResponse
import com.example.data.mapper.mapToDomain
import com.example.newsuktech.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import io.mockk.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Assert.assertEquals
import retrofit2.Response
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CoinsListRepositoryImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @get:Rule
    val coroutineRule = MainDispatcherRule()


    private lateinit var api: Api
    private lateinit var apiResponseHandler: ApiResponseHandler<List<CoinResponse>>
    private lateinit var repository: CoinsListRepositoryImpl

    @Before
    fun setUp() {
        api = mockk()
        apiResponseHandler = mockk()
        repository = CoinsListRepositoryImpl(api, apiResponseHandler)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test get list of coins returns coin data`() = runBlocking {
        val coinResponse = listOf(
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
            ),
            CoinResponse(
                "bitcoin-two",
                "Bitcoin",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            )
        )

        val coinData = coinResponse.map { it.mapToDomain() }

        coEvery { api.getCoinsList() } returns Response.success(coinResponse)

        coEvery { apiResponseHandler.handleApiCall<List<CoinResponse>>(any()) } returns flowOf(
            coinResponse
        )

        val result = repository.getCoins().first()

        assertEquals(coinData, result)
    }

}