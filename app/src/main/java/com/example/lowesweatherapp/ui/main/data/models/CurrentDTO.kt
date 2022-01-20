package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class CurrentDTO (
        @SerializedName("dt") val dt: Long,
    @SerializedName("temp") val temp: String,
    @SerializedName("feels_like") val feels_like: String,
    @SerializedName("pressure") val pressure: String,
    @SerializedName("clouds") val clouds: String,
    @SerializedName("visibility") val visibility: String,
    @SerializedName("wind_speed") val wind_speed: String,
    @SerializedName("wind_deg") val wind_deg: String
)