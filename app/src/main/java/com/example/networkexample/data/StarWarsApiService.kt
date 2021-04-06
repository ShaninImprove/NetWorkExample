package com.example.networkexample.data

import com.example.networkexample.data.model.ListResponseApiModel
import com.example.networkexample.data.model.SimpleCharacterApiModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface StarWarsApiService {

    @GET("people")
    fun getCharacters() : Single<ListResponseApiModel<SimpleCharacterApiModel>>
}