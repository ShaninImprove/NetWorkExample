package com.example.networkexample.data.network

import retrofit2.Retrofit

class NetworkServiceHolder {

    companion object {
        var retrofit: Retrofit? = null
        set(value) {
            retrofitService = value!!.create(StarWarsApiService::class.java)
            field = value
        }

        var retrofitService: StarWarsApiService? = null
    }
}