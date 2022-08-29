package com.abrsoftware.weatherworld.domain

sealed class Resourse<T>(val data: T? = null, val message: String? = null) {
    class Succes<T>(data: T?) : Resourse<T>(data)
    class Error<T>(message: String, data: T? = null) : Resourse<T>(data, message)
}
