package com.abrsoftware.weatherworld.domain

import com.abrsoftware.weatherworld.data.WeatherRepository
import javax.inject.Inject

class WeatherUserCase @Inject constructor(
    private val repository: WeatherRepository
){
    suspend fun getWeather(lat: Double, lon: Double):Resourse<WeatherInfo>{
        return repository.getWeather(lat, lon)
    }
}