package com.example.domain.interactors.coindetailusecase

import com.example.domain.model.CoinData
import com.example.domain.repository.CoinDetailRepository
import com.example.domain.utilities.annotations.OpenForTesting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


@OpenForTesting
open class GetCoinDetailUsecaseImp @Inject constructor(
    private val repository: CoinDetailRepository
) : GetCoinDetailUsecase {
    override suspend operator fun invoke(id: String): Flow<CoinData?> = channelFlow {
        repository.getCoin(id).collectLatest { data ->
            data?.let {
                send(it)
            }
        }
    }
}
