package com.example.domain.model

data class CoinData(
    val id: String = "",
    val name: String = "",
    val type: String = "",
    val isActive: Boolean = false,
    val symbol: String = "",
    val logo: String = "",
    val rank: Int = -1,
    val platform: String = "",
    val description: String = ""
)