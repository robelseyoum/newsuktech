package com.example.newsuktech.utilities.extensions

import com.example.domain.model.CoinData
import com.example.domain.model.CoinDataState

fun mapToCollection(coinDataList: List<CoinData>): Collection<CoinDataState> {
    return coinDataList.map { coinData ->
        CoinDataState(coinData)
    }
}