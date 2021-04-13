package com.example.networkexample.data.network.model

import com.google.gson.annotations.SerializedName

data class CharacterPropertiesApiModel(
    @SerializedName("height")
    val height: Int,
    @SerializedName("mass")
    val mass: Int,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String
)