package com.example.weatherapp.domain.usecase.weather

import com.example.weatherapp.domain.entity.Forecast
import com.example.weatherapp.domain.entity.Weather
import com.example.weatherapp.domain.repository.IWeatherRepository
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(
    private val repository: IWeatherRepository
) {

    suspend operator fun invoke(cityId: Int): Forecast {
        return repository.getForecast(cityId)
    }
}