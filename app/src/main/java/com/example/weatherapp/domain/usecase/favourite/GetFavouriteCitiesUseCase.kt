package com.example.weatherapp.domain.usecase.favourite

import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.repository.IFavouriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: IFavouriteRepository
) {

    operator fun invoke(): Flow<City> {
        return repository.favouriteCities
    }
}