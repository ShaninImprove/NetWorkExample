package com.example.networkexample.data

import com.example.networkexample.data.model.CharacterApiModel
import com.example.networkexample.data.model.ItemResponseApiModel
import com.example.networkexample.data.model.ListResponseApiModel
import com.example.networkexample.data.model.SimpleCharacterApiModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {

    @GET("people")
    fun getCharacters() : Single<ListResponseApiModel<SimpleCharacterApiModel>>

    @GET("people/{characterId}")
    fun getCharacterInfo(@Path("characterId") characterId: Int) : Single<ItemResponseApiModel<CharacterApiModel>>
}