package com.example.weatherapp.domain.entity

import android.icu.util.Calendar

data class Weather(
    val tempC: Float,
    val conditionText: String,
    val conditionIconUrl: String,
    val date: Calendar?,
)
