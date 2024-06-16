package com.example.newsuktech.coinlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.interactors.coinsusecase.GetCoinsUseCase
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
class CoinListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var getCoinsUseCase: GetCoinsUseCase
    private lateinit var viewModel: CoinListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getCoinsUseCase = mockk()
        viewModel = CoinListViewModel(getCoinsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `test fetchCoins throws exception`() = runBlocking {
        // Mock the use case to throw an exception
        val exception = RuntimeException("Something went wrong")
        coEvery { getCoinsUseCase.invoke() } returns flow { throw exception }

        // Trigger fetchCoins
        viewModel.fetchCoins()

        // When
        val thrownException = Assert.assertThrows(RuntimeException::class.java) {
            runBlocking {
                getCoinsUseCase.invoke().first()
            }
        }

        // Verify
        Assert.assertEquals("Something went wrong", thrownException.message)
    }


    @Test
    fun `test fetchCoins returns empty list`() = runBlocking {
        // Mock the use case behavior to return an empty list
        coEvery { getCoinsUseCase.invoke() } returns flowOf(emptyList())

        // Trigger fetchCoins
        viewModel.fetchCoins()

        // Given
        val expectedResult = emptyList<CoinData>()

        // When
        val result = getCoinsUseCase.invoke().first()

        // Verify
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `test fetchCoins returns coin data successfully`() = runBlocking {
        // Create a list of CoinData objects
        val coinDataList = listOf(
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
            ),
            CoinData(
                "2",
                "Ethereum",
                "BTC",
                true,
                "type",
                "logo",
                289,
                "platform",
                "description"
            ),
            CoinData(
                "3",
                "Cardano",
                "BTC",
                true,
                "type",
                "logo",
                289,
                "platform",
                "description"
            )
        )

        // Mock the use case behavior
        coEvery { getCoinsUseCase.invoke() } returns flowOf(coinDataList)

        // Trigger fetchCoins
        viewModel.fetchCoins()

        val coinDataResult = getCoinsUseCase.invoke().first()

        // Assert the results
        assertEquals(coinDataList, coinDataResult)
    }
}
