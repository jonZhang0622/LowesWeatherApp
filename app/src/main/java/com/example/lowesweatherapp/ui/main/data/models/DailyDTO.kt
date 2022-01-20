package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class DailyDTO (
    @SerializedName("dt") val dt: String,
    @SerializedName("temp") val temp: TempDTO,
    @SerializedName("feels_like") val feels_like: FeelsLikeDTO

)