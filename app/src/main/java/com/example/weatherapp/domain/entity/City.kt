package com.example.weatherapp.domain.entity

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
data class City(
    val id: Int,
    val name: String,
    val country: String,
): Parcelable
