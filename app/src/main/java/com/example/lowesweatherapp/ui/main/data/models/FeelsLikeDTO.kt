package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

class FeelsLikeDTO (
        @SerializedName("day") val day: String,
        @SerializedName("night") val night: String,
        @SerializedName("eve") val eve: String,
        @SerializedName("morn") val morn: String
        )