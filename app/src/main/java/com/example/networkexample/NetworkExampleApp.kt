package com.example.networkexample

import android.app.Application
import com.example.networkexample.data.network.NetworkServiceHolder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRetrofitService()
    }

    private fun initRetrofitService() {
        NetworkServiceHolder.retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}