package com.example.data.repository

import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.mapper.mapToDomain
import com.example.domain.model.CoinData
import com.example.domain.repository.CoinsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class CoinsListRepositoryImpl @Inject constructor(
    private val api: Api,
    private val apiResponseHandler: ApiResponseHandler<*>
) : CoinsListRepository {
    override suspend fun getCoins(): Flow<List<CoinData>?> {
        return apiResponseHandler.handleApiCall { api.getCoinsList() }
            .map { remoteCoinsResponse ->
                remoteCoinsResponse?.map {
                    it.mapToDomain()
                }
            }
    }
}