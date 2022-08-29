package com.abrsoftware.weatherworld.di

import android.content.Context
import com.abrsoftware.weatherworld.R
import com.abrsoftware.weatherworld.data.network.WeatherApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
    @Provides
    @Singleton
    fun providerRetrofit(@ApplicationContext context: Context): Retrofit{
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.end_point))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): WeatherApiClient {
        return retrofit.create(WeatherApiClient::class.java)
    }

}
