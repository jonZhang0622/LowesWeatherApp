package com.example.lowesweatherapp.ui.main.data.repos

import com.example.lowesweatherapp.ui.main.data.remote.network.WeatherManager

object WeatherRepo {

    private val weatherManager by lazy { WeatherManager() }

    fun getCoord(city: String) = weatherManager.getCoord(city)

    fun getWeather(lat: String, lon: String) = weatherManager.getWeather(lat, lon)
}