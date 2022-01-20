package com.example.lowesweatherapp.ui.main.data.remote.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(WeatherManager.WEATHER_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }

    val coordService: WeatherManager.CoordService = retrofit.create()
    val weatherService: WeatherManager.WeatherService = retrofit.create()

}