package com.example.weatherapp.domain.usecase.favourite

import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.repository.IFavouriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveFavouriteStateUseCase @Inject constructor(
    private val repository: IFavouriteRepository
) {

    operator fun invoke(cityId: Int): Flow<Boolean> {
        return repository.observeIsFavourite(cityId)
    }
}