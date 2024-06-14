package com.example.data.api.response

import com.google.gson.annotations.SerializedName

data class RemoteCoinsResponse (
    val status: List<CoinResponse>
)

data class CoinResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("symbol")
    val symbol: String? = null,

    @SerializedName("logo")
    val logo: String? = null,

    @SerializedName("tags")
    val tags: List<CoinTagResponse>? = null,

    @SerializedName("description")
    val description: String? = null
)

