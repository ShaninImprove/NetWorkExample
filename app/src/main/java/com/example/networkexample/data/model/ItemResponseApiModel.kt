package com.example.networkexample.data.model

import com.google.gson.annotations.SerializedName

data class ItemResponseApiModel<T>(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: T
)
