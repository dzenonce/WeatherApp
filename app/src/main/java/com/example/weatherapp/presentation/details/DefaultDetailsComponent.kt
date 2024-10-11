package com.example.weatherapp.presentation.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.presentation.extensions.componentScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultDetailsComponent @AssistedInject constructor(
    private val detailStoreFactory: DetailStoreFactory,
    @Assisted("city") private val city: City,
    @Assisted("onBackClick") private val onBackClick: () -> Unit,
    @Assisted("componentContext") componentContext: ComponentContext
) : IDetailsComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore { detailStoreFactory.create(city) }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    DetailStore.Label.ClickBack -> {
                        onBackClick()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<DetailStore.State> = store.stateFlow

    override fun onClickBack() {
        store.accept(DetailStore.Intent.ClickBack)
    }

    override fun onClickChangeFavouriteStatus() {
        store.accept(DetailStore.Intent.ClickChangeFavouriteStatus)
    }

    @AssistedFactory
    interface Factory {

        fun create(
            @Assisted("city") city: City,
            @Assisted("onBackClick") onBackClick: () -> Unit,
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultDetailsComponent
    }
}