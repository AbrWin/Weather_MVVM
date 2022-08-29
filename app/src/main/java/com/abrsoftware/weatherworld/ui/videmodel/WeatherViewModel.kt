package com.abrsoftware.weatherworld.ui.videmodel

import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrsoftware.weatherworld.domain.LocationTracker
import com.abrsoftware.weatherworld.domain.Resourse
import com.abrsoftware.weatherworld.domain.WeatherUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUserCase: WeatherUserCase,
    private val locationTracker: LocationTracker,
) : ViewModel() {

    var state: WeatherState by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            locationTracker.getCurrentLocation()?.let {location->
                when(val result = weatherUserCase.getWeather(location.latitude, location.longitude)){
                    is Resourse.Succes->{
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                        state.weatherInfo!!.currentWeatherData!!.time
                    }
                    is Resourse.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }

            }?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}