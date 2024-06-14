package com.example.domain.interactors.coinsusecase

import com.example.domain.model.CoinData
import com.example.domain.repository.CoinsListRepository
import com.example.domain.utilities.annotations.OpenForTesting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


@OpenForTesting
open class GetCoinsUseCaseImp @Inject constructor(
    private val repository: CoinsListRepository
) : GetCoinsUsecase {
   override suspend operator fun invoke(): Flow<List<CoinData>?> = channelFlow {
        repository.getCoins().collectLatest { data ->
            data?.let {
                send(it)
            }
        }
    }
}
