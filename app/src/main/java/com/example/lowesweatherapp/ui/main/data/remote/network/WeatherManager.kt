package com.example.lowesweatherapp.ui.main.data.remote.network

import com.example.lowesweatherapp.ui.main.data.models.CoordResponseDTO
import com.example.lowesweatherapp.ui.main.data.models.WeatherResponseDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

class WeatherManager {
    private val coordService: CoordService by lazy { RetrofitService.coordService }
    private val service: WeatherService by lazy { RetrofitService.weatherService }

    fun getCoord(q: String) = coordService.getCoords(q, APP_ID)

    fun getWeather(lat: String, lon: String) =
        service.getWeather(lat, lon, "imperial", "minutely", APP_ID)

    interface CoordService {
        @GET("/data/2.5/forecast")
        fun getCoords(
            @Query("q") q: String,
            @Query("appid") appid: String
        ): Single<CoordResponseDTO>
    }

    interface WeatherService {
        @GET("/data/2.5/onecall")
        fun getWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("units") units: String,
            @Query("exclude") exclude: String,
            @Query("appid") appid: String
        ): Single<WeatherResponseDTO>
    }

    companion object {
        const val WEATHER_HOST = "https://api.openweathermap.org/"
        private const val APP_ID = "65d00499677e59496ca2f318eb68c049"
    }
}