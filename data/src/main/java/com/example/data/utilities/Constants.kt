package com.example.data.utilities

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class Constants {
    companion object {
        val requestIODispatchers: CoroutineDispatcher = Dispatchers.IO
        val requestMainDispatchers: CoroutineDispatcher = Dispatchers.Main
        const val COIN_PAPRIKA_BASE_URL = "https://api.coinpaprika.com"
        const val COINS_PAPRIKA_LIST = "/v1/coins"
        const val COIN_PAPRIKA_DETAIL_ID = "/v1/coins/{id}"
        const val COIN_ID = "coinId"
        const val API_TIMEOUT = 50L
        const val ERROR_UNKNOWN = "Unknown error"
        const val NETWORK_ERROR_UNKNOWN = "Unknown network error"
        const val NETWORK_ERROR_TIMEOUT = "Network timeout"
        const val EMPTY_RESPONSE_ERROR = "Response body is empty or null"
        const val EMPTY = ""
        const val DATA_KEY = "data"
    }
}