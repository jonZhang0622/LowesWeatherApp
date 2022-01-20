package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class WeatherDTO (
    @SerializedName("id") val id: String,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)