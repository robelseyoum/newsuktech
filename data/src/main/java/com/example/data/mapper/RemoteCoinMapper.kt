package com.example.data.mapper

import com.example.data.api.response.CoinResponse
import com.example.data.utilities.Constants.Companion.EMPTY
import com.example.domain.model.CoinData


fun CoinResponse.mapToDomain() =
    CoinData(
        id = id,
        name = name ?: EMPTY,
        type = type ?: EMPTY,
        isActive = isActive ?: false,
        symbol = symbol ?: EMPTY,
        logo = logo ?: EMPTY,
        rank = rank ?: -1,
        platform = platform ?: EMPTY,
        description = description ?: EMPTY
    )



