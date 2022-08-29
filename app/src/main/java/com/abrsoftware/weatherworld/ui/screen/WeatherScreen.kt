package com.abrsoftware.weatherworld.ui.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abrsoftware.weatherworld.ui.components.CardItemWeather
import com.abrsoftware.weatherworld.ui.components.WeatherForecast
import com.abrsoftware.weatherworld.ui.theme.Orange300
import com.abrsoftware.weatherworld.ui.theme.Violet300
import com.abrsoftware.weatherworld.ui.videmodel.WeatherState
import com.abrsoftware.weatherworld.ui.videmodel.WeatherViewModel


@SuppressLint("NewApi")
@Composable
fun WeatherScreen(
    state: WeatherState,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    Box(
        modifier =
        Modifier.fillMaxSize().background(Color.White)
    ) {
        Column {
            CardItemWeather(state)
            WeatherForecast(state = viewModel.state)
        }

        if(viewModel.state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        viewModel.state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevScreen() {
}