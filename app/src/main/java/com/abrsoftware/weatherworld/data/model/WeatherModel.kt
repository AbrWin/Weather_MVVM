package com.abrsoftware.weatherworld.data.model

import com.abrsoftware.weatherworld.domain.WeatherDataModel
import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("hourly") val weatherData: WeatherDataModelDto
)
