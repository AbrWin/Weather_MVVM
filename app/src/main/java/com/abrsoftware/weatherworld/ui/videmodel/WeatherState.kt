package com.abrsoftware.weatherworld.ui.videmodel

import com.abrsoftware.weatherworld.domain.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
