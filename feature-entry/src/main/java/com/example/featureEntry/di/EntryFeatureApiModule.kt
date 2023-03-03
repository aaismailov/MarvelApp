package com.example.featureEntry.di

import com.example.featureEntry.EntryFeatureApiImpl
import com.example.featureEntryApi.EntryFeatureApi
import dagger.Binds
import dagger.Module

@Module
interface EntryFeatureApiModule {
    @Binds
    fun bindEntryFeatureApi(api: EntryFeatureApiImpl): EntryFeatureApi
}