package com.example.weatherapp.presentation.details

import kotlinx.coroutines.flow.StateFlow

interface IDetailsComponent {

    val model: StateFlow<DetailStore.State>

    fun onClickBack()

    fun onClickChangeFavouriteStatus()
}