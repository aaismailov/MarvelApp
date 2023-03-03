package com.example.project.dagger

import com.example.featureDetails.di.DetailsFeatureApiModule
import com.example.featureEntry.di.EntryFeatureApiModule
import com.example.featureFavorite.di.FavoriteFeatureApiModule
import com.example.featureHome.di.HomeFeatureApiModule
import com.example.featureMain.di.MainFeatureApiModule
import com.example.featureProfile.di.ProfileFeatureApiModule
import dagger.Module

@Module(
    includes = [
        MainFeatureApiModule::class,
        HomeFeatureApiModule::class,
        ProfileFeatureApiModule::class,
        DetailsFeatureApiModule::class,
        FavoriteFeatureApiModule::class,
        EntryFeatureApiModule::class
    ]
)
class AppModule