package com.abrsoftware.weatherworld.data

import android.annotation.SuppressLint
import android.util.Log
import com.abrsoftware.weatherworld.data.model.WeatherModel
import com.abrsoftware.weatherworld.data.network.WeatherService
import com.abrsoftware.weatherworld.domain.*
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherService
){
   @SuppressLint("NewApi")
   suspend fun getWeather(lat: Double, long: Double): Resourse<WeatherInfo>{
      return try {
          Resourse.Succes(
              data = api.getWeatherData(
                  lat = lat,
                  long = long
              ).toWeatherInfo()
          )

      }catch (e: Exception){
          e.printStackTrace()
          Resourse.Error(e.message ?: "An unknow error occured.")
      }
   }
}