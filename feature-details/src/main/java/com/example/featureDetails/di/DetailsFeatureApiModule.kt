package com.example.featureDetails.di

import com.example.featureDetails.DetailsFeatureApiImpl
import com.example.featureDetailsApi.DetailsFeatureApi
import dagger.Binds
import dagger.Module

@Module
interface DetailsFeatureApiModule {
    @Binds
    fun bindDetailsFeatureApi(api: DetailsFeatureApiImpl): DetailsFeatureApi
}