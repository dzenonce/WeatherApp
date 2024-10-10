package com.example.weatherapp.domain.usecase.search

import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.repository.ISearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: ISearchRepository
) {

    suspend operator fun invoke(query: String): List<City> {
        return repository.search(query)
    }
}