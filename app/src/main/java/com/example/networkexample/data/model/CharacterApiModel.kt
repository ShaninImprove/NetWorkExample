package com.example.networkexample.data.model

import com.google.gson.annotations.SerializedName

data class CharacterApiModel(
    @SerializedName("properties")
    val properties: CharacterPropertiesApiModel
)
