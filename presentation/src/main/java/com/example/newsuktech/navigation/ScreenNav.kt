package com.example.newsuktech.navigation


sealed class ScreenNav(val route: String) {
    data object CoinListScreen : ScreenNav(route = "coin-ist")
    data object CoinDetailScreen : ScreenNav(route = "coin-detail")
}