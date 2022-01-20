package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

class CoordDTO (
    @SerializedName("lat") val lat: String,
    @SerializedName("lon") val lon: String
)