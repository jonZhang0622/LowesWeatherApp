package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class HourlyDTO (
    @SerializedName("dt") val dt: String,
    @SerializedName("temp") val temp: String,
    @SerializedName("feels_like") val feels_like: String
        )