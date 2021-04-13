package com.example.networkexample.data.network.model

import com.google.gson.annotations.SerializedName

data class CharacterApiModel(
    @SerializedName("properties")
    val properties: CharacterPropertiesApiModel
)
