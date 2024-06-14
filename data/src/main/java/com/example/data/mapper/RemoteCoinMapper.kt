package com.example.data.mapper

import com.example.data.api.response.CoinResponse
import com.example.domain.model.CoinData
import com.example.domain.model.CoinTagData


fun CoinResponse.mapToDomain() =
    CoinData(
        id = id,
        name = name ?: "",
        symbol = symbol ?: "",
        logo = logo ?: "",
        tags = mapToCoinTag(),
        description = ""
    )



private fun CoinResponse.mapToCoinTag() =
    (tags ?: emptyList())
        .map {
            CoinTagData(
                id = it.id,
                name = it.name
            )
        }
