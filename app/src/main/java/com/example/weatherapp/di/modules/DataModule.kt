package com.example.weatherapp.di.modules

import android.content.Context
import com.example.weatherapp.data.local.db.FavouriteCitiesDao
import com.example.weatherapp.data.local.db.FavouriteDatabase
import com.example.weatherapp.data.network.api.ApiFactory
import com.example.weatherapp.data.network.api.ApiService
import com.example.weatherapp.data.repository.FavouriteRepositoryImpl
import com.example.weatherapp.data.repository.SearchRepositoryImpl
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.di.annotations.ApplicationScope
import com.example.weatherapp.domain.repository.IFavouriteRepository
import com.example.weatherapp.domain.repository.ISearchRepository
import com.example.weatherapp.domain.repository.IWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): IFavouriteRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): ISearchRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): IWeatherRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @[ApplicationScope Provides]
        fun provideDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouritesCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}