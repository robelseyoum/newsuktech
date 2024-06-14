package com.example.data.repository

import com.example.data.api.Api
import com.example.data.api.ApiResponseHandler
import com.example.data.mapper.mapToDomain
import com.example.domain.model.CoinData
import com.example.domain.repository.CoinDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class CoinDetailRepositoryImpl @Inject constructor(
    private val api: Api,
    private val apiResponseHandler: ApiResponseHandler<*>
) : CoinDetailRepository {
    override suspend fun getCoin(id: String): Flow<CoinData?> {
        return apiResponseHandler.handleApiCall {
            api.getCoinDetail(id)
        }.map { it?.mapToDomain() }
    }
}