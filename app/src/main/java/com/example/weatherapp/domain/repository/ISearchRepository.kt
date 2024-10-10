package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.entity.City

interface ISearchRepository {

    suspend fun search(query: String): List<City>
}