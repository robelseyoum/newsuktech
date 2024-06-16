package com.example.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.api.response.CoinResponse
import com.example.data.mapper.mapToDomain
import com.example.domain.model.CoinData
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import okio.IOException
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class CoinsListRepositoryImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

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
    fun `test getCoins returns empty list`() = runBlocking {
        // Mock the API to return an empty list
        val emptyResponse: Response<List<CoinResponse>> = Response.success(emptyList())

        //Given
        coEvery { api.getCoinsList() } returns emptyResponse
        coEvery { apiResponseHandler.handleApiCall<List<CoinResponse>>(any()) } returns flowOf(
            emptyList()
        )

        // When
        val result = repository.getCoins().first()

        // Verify
        assertEquals(emptyList<CoinData>(), result)
    }

    @Test
    fun `test getCoins API throws exception`() = runBlocking {
        // Mock the API to throw an IOException
        val exception = IOException("Network error")

        //Given
        coEvery { api.getCoinsList() } throws exception
        coEvery { apiResponseHandler.handleApiCall<List<CoinResponse>>(any()) } throws exception

        // Assert that the exception is thrown when getting coins from the repository
        val thrownException = assertThrows(IOException::class.java) {
            runBlocking {
                repository.getCoins().first()
            }
        }

        // Verify
        assertEquals("Network error", thrownException.message)
    }


    @Test
    fun `test getCoins ApiResponseHandler throws exception`() = runBlocking {
        // Mock the API to return a successful response
        val coinResponseList = listOf(
            CoinResponse(
                "1",
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
                "2",
                "Ethereum",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            ),
            CoinResponse(
                "3",
                "Cardano",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            )
        )
        val successfulResponse: Response<List<CoinResponse>> = Response.success(coinResponseList)
        coEvery { api.getCoinsList() } returns successfulResponse

        // Mock the ApiResponseHandler to throw an exception
        val exception = RuntimeException("Handler error")
        coEvery { apiResponseHandler.handleApiCall<List<CoinResponse>>(any()) } throws exception

        // Assert that the exception is thrown when getting coins from the repository
        val thrownException = assertThrows(RuntimeException::class.java) {
            runBlocking {
                repository.getCoins().first()
            }
        }

        // Verify the exception message
        assertEquals("Handler error", thrownException.message)
    }


    @Test
    fun `test get list of coins returns sorted by name coin data`() = runBlocking {
        val coinResponseList = listOf(
            CoinResponse(
                "1",
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
                "2",
                "Ethereum",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            ),
            CoinResponse(
                "3",
                "Cardano",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            )
        )

        val expectedCoinDataList = listOf(
            CoinResponse(
                "1",
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
                "2",
                "Ethereum",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            ),
            CoinResponse(
                "3",
                "Cardano",
                "BTC",
                "logo",
                "type",
                true,
                289,
                "platform",
                "description"
            )
        )

        val coinData = expectedCoinDataList.map { it.mapToDomain() }.sortedBy { it.name }

        // Given
        coEvery { api.getCoinsList() } returns Response.success(coinResponseList)

        coEvery { apiResponseHandler.handleApiCall<List<CoinResponse>>(any()) } returns flowOf(
            coinResponseList
        )
        // When
        val result = repository.getCoins().first()

        // Check
        assertEquals(coinData, result)
    }
}