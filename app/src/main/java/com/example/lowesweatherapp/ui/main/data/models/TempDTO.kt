package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class TempDTO (
        @SerializedName("day") val day: String,
        @SerializedName("min") val min: String,
        @SerializedName("max") val max: String,
        @SerializedName("night") val night: String,
        @SerializedName("eve") val eve: String,
        @SerializedName("morn") val morn: String

        )