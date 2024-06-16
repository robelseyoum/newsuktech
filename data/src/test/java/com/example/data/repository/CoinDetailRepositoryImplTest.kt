package com.example.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.api.response.CoinResponse
import com.example.data.mapper.mapToDomain
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import okio.IOException
import org.junit.After
import org.junit.Assert.assertThrows
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response


@ExperimentalCoroutinesApi
class CoinDetailRepositoryImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

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
    fun `test getCoinDetail API throws exception`() = runBlocking {
        // Mock the API to throw an IOException
        val exception = IOException("Network error")

        //Given
        coEvery { api.getCoinDetail(any()) } throws exception
        coEvery { apiResponseHandler.handleApiCall<CoinResponse>(any()) } throws exception

        // Assert that the exception is thrown when getting coin detail from the repository
        val thrownException = assertThrows(IOException::class.java) {
            runBlocking {
                repository.getCoin("1").first()
            }
        }

        // Verify the exception message
        assertEquals("Network error", thrownException.message)
    }

    @Test
    fun `test getCoinDetail ApiResponseHandler throws exception`() = runBlocking {
        // Mock the API to return a successful response
        val coinResponse =  CoinResponse(
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
        val successfulResponse: Response<CoinResponse> = Response.success(coinResponse)
        // Mock the ApiResponseHandler to throw an exception
        val exception = RuntimeException("Handler error")

        //Given
        coEvery { api.getCoinDetail(any()) } returns successfulResponse
        coEvery { apiResponseHandler.handleApiCall<CoinResponse>(any()) } throws exception

        // Assert that the exception is thrown when getting coin detail from the repository
        val thrownException = assertThrows(RuntimeException::class.java) {
            runBlocking {
                repository.getCoin("1").first()
            }
        }

        // Verify the exception message
        assertEquals("Handler error", thrownException.message)
    }

    @Test
    fun `test get coin detail returns coin data`() = runBlocking {
        // Create a list of CoinResponse objects
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

        // Given
        coEvery { api.getCoinDetail("bitcoin") } returns Response.success(coinResponse)

        coEvery { apiResponseHandler.handleApiCall<CoinResponse>(any()) } returns flowOf(
            coinResponse
        )

        // When
        val result = repository.getCoin("bitcoin").first()

        // Check
        assertEquals(coinData, result)
    }

}