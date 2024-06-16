package com.example.domain.interactors.coindetailusecase

import com.example.domain.model.CoinData
import kotlinx.coroutines.flow.Flow

interface GetCoinDetailUseCase {
    suspend operator fun invoke(id: String): Flow<CoinData?>
}