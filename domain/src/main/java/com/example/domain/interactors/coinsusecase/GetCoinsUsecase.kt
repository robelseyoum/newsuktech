package com.example.domain.interactors.coinsusecase

import com.example.domain.model.CoinData
import kotlinx.coroutines.flow.Flow

interface GetCoinsUseCase {
    suspend operator fun invoke(): Flow<List<CoinData>?>
}