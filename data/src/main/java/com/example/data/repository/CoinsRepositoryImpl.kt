package com.example.data.repository

import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.mapper.mapToDomain
import com.example.domain.model.CoinData
import com.example.domain.repository.CoinsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class CoinsRepositoryImpl @Inject constructor(
    private val api: Api,
    private val apiResponseHandler: ApiResponseHandler<*>
) : CoinsRepository {
    override suspend fun getCoins(): Flow<List<CoinData>?> {
        return apiResponseHandler.handleApiCall { api.getCoins() }
            .map { remoteCoinsResponse ->
                remoteCoinsResponse?.status?.map { it.mapToDomain() }
            }
    }
}