package com.example.domain.interactors.coindetailusecase

import com.example.domain.model.CoinData
import kotlinx.coroutines.flow.Flow

interface GetCoinDetailUsecase {
    suspend operator fun invoke(id: String): Flow<CoinData?>
}