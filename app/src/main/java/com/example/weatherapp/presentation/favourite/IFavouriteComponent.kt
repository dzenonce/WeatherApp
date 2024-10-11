package com.example.weatherapp.presentation.favourite

import com.example.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface IFavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun onClickFavourite()

    fun onCityItemClick(city: City)
}