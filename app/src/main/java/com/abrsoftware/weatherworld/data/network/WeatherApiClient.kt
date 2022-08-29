package com.abrsoftware.weatherworld.data.network

import com.abrsoftware.weatherworld.data.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {
    @GET(Routes.GET_SESSION)
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): Response<WeatherModel>
}
