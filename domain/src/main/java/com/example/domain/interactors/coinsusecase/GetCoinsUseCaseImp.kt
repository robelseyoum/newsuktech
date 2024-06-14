package com.example.domain.interactors.coinsusecase

import com.example.domain.model.CoinData
import com.example.domain.repository.CoinsRepository
import com.example.newsuktech.utilities.annotations.OpenForTesting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


@OpenForTesting
open class GetStatusUseCase @Inject constructor(
    private val repository: CoinsRepository
) : GetCoinsUsecase {
   override suspend operator fun invoke(): Flow<List<CoinData>?> = channelFlow {
        repository.getCoins().collectLatest { data ->
            data?.let {
                send(it)
            }
        }
    }
}
