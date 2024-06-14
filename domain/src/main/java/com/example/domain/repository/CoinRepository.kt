package com.example.domain.repository

import com.example.domain.model.CoinData
import kotlinx.coroutines.flow.Flow


interface CoinsRepository {
  suspend fun getCoins(): Flow<List<CoinData>?>
}