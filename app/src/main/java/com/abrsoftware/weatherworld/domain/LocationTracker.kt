package com.abrsoftware.weatherworld.domain

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}