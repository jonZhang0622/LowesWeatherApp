package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class WeatherResponseDTO(
        @SerializedName("timezone") val timezone: String,
        @SerializedName("weather") val weather: List<WeatherDTO>,
        @SerializedName("current") val current: CurrentDTO,
        @SerializedName("hourly") val hourly: List<HourlyDTO>,
        @SerializedName("daily") val daily: List<DailyDTO>)