package com.example.featureFavorite.di

import com.example.featureFavorite.FavoriteFeatureApiImpl
import com.example.featureFavoriteApi.FavoriteFeatureApi
import dagger.Binds
import dagger.Module

@Module
interface FavoriteFeatureApiModule {
    @Binds
    fun bindFavoriteFeatureApi(api: FavoriteFeatureApiImpl): FavoriteFeatureApi
}