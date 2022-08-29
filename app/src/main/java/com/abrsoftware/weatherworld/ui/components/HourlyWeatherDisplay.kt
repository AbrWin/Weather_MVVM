package com.abrsoftware.weatherworld.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abrsoftware.weatherworld.domain.WeatherData
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    textColor: Color = Color.White
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(80.dp),
        backgroundColor = weatherData.weatherType.color,
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = formattedTime,
                color = Color.White
            )
            Image(
                painter = painterResource(id = weatherData.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )
            Text(
                text = "${weatherData.temperatureCelsius}°C",
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        }
    }

}