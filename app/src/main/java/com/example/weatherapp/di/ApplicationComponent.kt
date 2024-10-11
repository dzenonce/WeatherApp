package com.example.weatherapp.di

import android.content.Context
import com.example.weatherapp.di.annotations.ApplicationScope
import com.example.weatherapp.di.modules.DataModule
import com.example.weatherapp.di.modules.PresentationModule
import com.example.weatherapp.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        PresentationModule::class
    ]
)
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}