package com.example.domain.interactors.coinsusecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.CoinData
import com.example.domain.repository.CoinsListRepository
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
class GetCoinsUseCaseImpTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var repository: CoinsListRepository
    private lateinit var getCoinsUseCase: GetCoinsUseCaseImp

    @Before
    fun setUp() {
        repository = mockk()
        getCoinsUseCase = GetCoinsUseCaseImp(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test getCoinsUseCase invoke to returns empty list`() = runBlocking {
        // Given
        coEvery { repository.getCoins() } returns flowOf(emptyList())

        // When
        val result = getCoinsUseCase.invoke().first()

        // Verify
        assertEquals(emptyList<CoinData>(), result)
    }

    @Test
    fun `test getCoinsUseCase invoke to throws exception`() = runBlocking {
        // Given
        val exception = RuntimeException("Something went wrong")
        coEvery { repository.getCoins() } throws exception

        // When
        val thrownException = assertThrows(RuntimeException::class.java) {
            runBlocking {
                getCoinsUseCase.invoke().first()
            }
        }

        // Verify
        assertEquals("Something went wrong", thrownException.message)
    }

    @Test
    fun `test invoke getCoinsUseCase and returns coin data`() = runBlocking {
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

        // Given
        coEvery { repository.getCoins() } returns flowOf(coinDataList)

        // When
        val result = getCoinsUseCase.invoke().first()

        // Check
        assertEquals(coinDataList, result)
    }

}
