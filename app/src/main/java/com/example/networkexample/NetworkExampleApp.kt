package com.example.networkexample

import android.app.Application
import androidx.room.Room
import com.example.networkexample.data.database.AppDataBase
import com.example.networkexample.data.database.DataBaseHolder
import com.example.networkexample.data.network.NetworkServiceHolder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRetrofitService()
        initDataBase()
    }

    private fun initRetrofitService() {
        NetworkServiceHolder.retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun initDataBase() {
        val db = Room.databaseBuilder(
            this, AppDataBase::class.java,
            "characters-db")
            .build()
        DataBaseHolder.database = db
    }
}