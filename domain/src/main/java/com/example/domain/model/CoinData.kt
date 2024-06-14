package com.example.domain.model

data class CoinData(
    val id: String = "",
    val name: String = "",
    val symbol: String = "",
    val logo: String = "",
    val tags: List<CoinTagData> = emptyList(),
    val description: String = ""
)