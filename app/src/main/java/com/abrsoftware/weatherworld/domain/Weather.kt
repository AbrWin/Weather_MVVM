package com.abrsoftware.weatherworld.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.abrsoftware.weatherworld.data.model.WeatherDataModelDto
import com.abrsoftware.weatherworld.data.model.WeatherModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Weather(
    val weatherData: WeatherDataModel
)

fun WeatherModel.toDomain() = Weather(weatherData.toDomain())

data class WeatherDataModel(
    val time: List<String>,
    val temperatures: List<Double>,
    val weatherCodes: List<Int>,
    val pressures: List<Double>,
    val windSpeeds: List<Double>,
    val humidities: List<Double>
)

fun WeatherDataModelDto.toDomain() = WeatherDataModel(time, temperatures, weatherCodes, pressures, windSpeeds, humidities)

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataModel.toWeatherDataMap() : Map<Int, List<WeatherData>>{
    return time.mapIndexed{ index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherModel.toWeatherInfo() : WeatherInfo{
    val weatherDataMap = weatherData.toDomain().toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
