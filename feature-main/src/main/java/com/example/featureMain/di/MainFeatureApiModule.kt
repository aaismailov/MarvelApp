package com.example.featureMain.di

import com.example.featureMain.MainFeatureApiImpl
import com.example.featureMainApi.MainFeatureApi
import dagger.Binds
import dagger.Module

@Module
interface MainFeatureApiModule {
    @Binds
    fun bindMainFeatureApi(api: MainFeatureApiImpl): MainFeatureApi
}