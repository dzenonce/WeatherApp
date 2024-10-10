package com.example.weatherapp.domain.usecase.favourite

import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.repository.IFavouriteRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: IFavouriteRepository
) {

    suspend fun addToFavouriteUseCase(city: City) {
        repository.addToFavourite(city)
    }

    suspend fun removeFromFavouriteUseCase(cityId: Int) {
        repository.removeFromFavourite(cityId)
    }
}