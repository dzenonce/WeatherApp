package com.example.weatherapp.di

import android.content.Context
import com.example.weatherapp.di.annotations.ApplicationScope
import com.example.weatherapp.di.modules.DataModule
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}