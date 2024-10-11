package com.example.weatherapp.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.weatherapp.presentation.details.IDetailsComponent
import com.example.weatherapp.presentation.favourite.IFavouriteComponent
import com.example.weatherapp.presentation.search.ISearchComponent

interface IRootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        data class Favourite(val component: IFavouriteComponent) : Child

        data class Search(val component: ISearchComponent) : Child

        data class Details(val component: IDetailsComponent) : Child
    }
}