package com.example.lowesweatherapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class CoordResponseDTO (
    @SerializedName("city") val city: CityDTO,
        )