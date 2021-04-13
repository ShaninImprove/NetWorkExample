package com.example.networkexample.data.network

import retrofit2.Retrofit

object NetworkServiceHolder {

        var retrofit: Retrofit? = null
        set(value) {
            retrofitService = value!!.create(StarWarsApiService::class.java)
            field = value
        }

        var retrofitService: StarWarsApiService? = null
}