package com.example.domain.interactors.coindetailusecase


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.CoinData
import com.example.domain.repository.CoinDetailRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import io.mockk.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCoinDetailUseCaseImpTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()


    private lateinit var repository: CoinDetailRepository
    private lateinit var getCoinDetailUseCase: GetCoinDetailUseCase

    @Before
    fun setUp() {
        repository = mockk()
        getCoinDetailUseCase = GetCoinDetailUseCaseImp(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test invoke getCoinDetailUseCase and returns coin data successfully`() = runBlocking {
        // Create a CoinData object
        val coinData =
            CoinData(
                "1",
                "Bitcoin",
                "BTC",
                false,
                "type",
                "logo",
                289,
                "platform",
                "description"
            )

        // Mock the repository behavior
        coEvery { repository.getCoin(any()) } returns flowOf(coinData)

        // Collect the result from the use case
        val result = getCoinDetailUseCase.invoke("1").first()

        // Verify the result is the same as the mocked data
        assertEquals(coinData, result)
    }

    @Test
    fun `test invoke getCoinDetailUseCase throws exception when repository throws exception`() = runBlocking {
        // Mock the repository to throw an exception
        val exception = RuntimeException("Something went wrong")
        coEvery { repository.getCoin(any()) } throws exception

        // Assert that the exception is thrown when invoking the use case
        val thrownException = assertThrows(RuntimeException::class.java) {
            runBlocking {
                getCoinDetailUseCase.invoke("1").first()
            }
        }

        // Verify the exception message
        assertEquals("Something went wrong", thrownException.message)
    }
}