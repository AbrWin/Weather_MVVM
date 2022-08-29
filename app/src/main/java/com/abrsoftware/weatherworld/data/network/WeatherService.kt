package com.abrsoftware.weatherworld.data.network

import android.content.Context
import com.abrsoftware.weatherworld.data.model.WeatherModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherService @Inject constructor(
    private val api: WeatherApiClient,
    @ApplicationContext private val context: Context
) {
    suspend fun getWeatherData(lat: Double, long: Double):WeatherModel{
        return withContext(Dispatchers.IO){
            val response = api.getWeatherData(lat, long)
            (response.body() as WeatherModel)
        }
    }
}
