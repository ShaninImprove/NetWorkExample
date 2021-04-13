package com.example.networkexample.data.network.model

import com.google.gson.annotations.SerializedName

data class ListResponseApiModel<T>(
    @SerializedName("message")
    val message: String,
    @SerializedName("results")
    val results: List<T>
)