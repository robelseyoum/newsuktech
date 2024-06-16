package com.example.newsuktech.coindetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.interactors.coindetailusecase.GetCoinDetailUseCase
import com.example.domain.model.CoinData
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CoinDetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var getCoinDetailUseCase: GetCoinDetailUseCase
    private lateinit var viewModel: CoinDetailViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getCoinDetailUseCase = mockk()
        viewModel = CoinDetailViewModel(getCoinDetailUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `test fetchCoinDetail throws exception`() = runBlocking {
        // Mock the use case to throw an exception
        val exception = RuntimeException("Something went wrong")
        coEvery { getCoinDetailUseCase.invoke(any()) } returns flow { throw exception }

        // Trigger initCoinDetail
        viewModel.fetchCoinDetail("1")

        // Assert that the exception is thrown when invoking the use case
        val thrownException = Assert.assertThrows(RuntimeException::class.java) {
            runBlocking {
                getCoinDetailUseCase.invoke("1").first()
            }
        }

        // Verify the exception message
        assertEquals("Something went wrong", thrownException.message)
    }


    @Test
    fun `test fetchCoinDetail returns coin data successfully`() = runBlocking {
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

        // Mock the use case behavior
        coEvery { getCoinDetailUseCase.invoke(any()) } returns flowOf(coinData)

        // Trigger fetchCoinDetail
        viewModel.fetchCoinDetail("1")

        val coinDetailResult = getCoinDetailUseCase.invoke("1").first()

        // Assert the results
        assertEquals(coinData, coinDetailResult)
    }
}