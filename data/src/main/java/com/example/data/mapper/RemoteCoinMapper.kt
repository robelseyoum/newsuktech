package com.example.data.mapper

import com.example.data.api.response.CoinResponse
import com.example.domain.model.CoinData


fun CoinResponse.mapToDomain() =
    CoinData(
        id = id,
        name = name ?: "",
        symbol = symbol ?: "",
        logo = logo ?: "",
        type = type ?: "",
        isActive = isActive ?: false,
        description = ""
    )



