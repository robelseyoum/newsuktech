package com.example.data.api

import com.example.data.api.response.CoinResponse
import com.example.data.utilities.Constants.Companion.COINS_PAPRIKA_LIST
import com.example.data.utilities.Constants.Companion.COIN_ID
import com.example.data.utilities.Constants.Companion.COIN_PAPRIKA_DETAIL_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * REST API access points
 * Using flow call arch
 */
interface Api {
    @GET(COINS_PAPRIKA_LIST)
    suspend fun getCoinsList(): Response<List<CoinResponse>>

    @GET(COIN_PAPRIKA_DETAIL_ID)
    suspend fun getCoinDetail(@Path(COIN_ID) id: String):  Response<CoinResponse>
}
