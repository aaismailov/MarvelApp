package com.example.featureProfile.di

import com.example.featureProfile.ProfileFeatureApiImpl
import com.example.featureProfileApi.ProfileFeatureApi
import dagger.Binds
import dagger.Module

@Module
interface ProfileFeatureApiModule {
    @Binds
    fun bindHomeFeatureApi(api: ProfileFeatureApiImpl): ProfileFeatureApi
}