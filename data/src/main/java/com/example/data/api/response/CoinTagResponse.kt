package com.example.data.api.response

import com.google.gson.annotations.SerializedName

data class CoinTagResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String
)