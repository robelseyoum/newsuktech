package com.example.data.api.response

import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("symbol")
    val symbol: String? = null,

    @SerializedName("logo")
    val logo: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("is_active")
    val isActive: Boolean? = null,

    @SerializedName("description")
    val description: String? = null
)

