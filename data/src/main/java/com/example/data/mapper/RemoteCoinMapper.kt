package com.example.data.mapper

import com.example.data.api.response.CoinResponse
import com.example.domain.model.CoinData


fun CoinResponse.mapToDomain() =
    CoinData(
        id = id,
        name = name ?: "",
        type = type ?: "",
        isActive = isActive ?: false,
        symbol = symbol ?: "",
        logo = logo ?: "",
        rank = rank ?: -1,
        platform = platform ?: "",
        description = description ?: ""
    )



