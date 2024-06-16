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
        const val COIN_ID = "id"
        const val EMPTY_RESPONSE_ERROR = "Response body is empty or null"
        const val EMPTY = ""
    }
}