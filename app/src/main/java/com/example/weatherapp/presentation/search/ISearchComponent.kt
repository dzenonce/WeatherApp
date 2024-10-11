package com.example.weatherapp.presentation.search

import com.example.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface ISearchComponent {

    val model: StateFlow<SearchStore.State>

    fun changeSearchQuery(query: String)

    fun onClickBack()

    fun onClickSearch()

    fun onClickCity(city: City)
}