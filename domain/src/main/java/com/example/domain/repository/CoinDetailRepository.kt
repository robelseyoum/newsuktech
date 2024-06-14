package com.example.domain.repository

import com.example.domain.model.CoinData
import kotlinx.coroutines.flow.Flow

interface CoinDetailRepository {
    suspend fun getCoin(id: String,): Flow<CoinData?>
}