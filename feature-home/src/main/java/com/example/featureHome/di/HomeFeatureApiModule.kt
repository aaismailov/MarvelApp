package com.example.featureHome.di

import com.example.featureHome.HomeFeatureApiImpl
import com.example.featureHomeApi.HomeFeatureApi
import dagger.Binds
import dagger.Module

@Module
interface HomeFeatureApiModule {
    @Binds
    fun bindHomeFeatureApi(api: HomeFeatureApiImpl): HomeFeatureApi
}