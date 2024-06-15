package com.example.domain.model

data class CoinData(
    val id: String = "",
    val name: String = "",
    val symbol: String = "",
    val logo: String = "",
    val type: String = "",
    val isActive: Boolean = false,
    val description: String = ""
)