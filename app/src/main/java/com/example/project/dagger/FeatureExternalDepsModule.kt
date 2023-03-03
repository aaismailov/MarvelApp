package com.example.project.dagger

import com.example.coreDi.dependency.FeatureExternalDeps
import com.example.coreDi.dependency.FeatureExternalDepsKey
import com.example.featureDetails.di.DetailsExternalDependencies
import com.example.featureEntry.di.EntryExternalDependencies
import com.example.featureFavorite.di.FavoriteExternalDependencies
import com.example.featureHome.di.HomeExternalDependencies
import com.example.featureMain.di.MainExternalDependencies
import com.example.featureProfile.di.ProfileExternalDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureExternalDepsModule {

    @Binds
    @IntoMap
    @FeatureExternalDepsKey(MainExternalDependencies::class)
    fun bindMainFeatureExternalDeps(appComponent: AppComponent): FeatureExternalDeps

    @Binds
    @IntoMap
    @FeatureExternalDepsKey(HomeExternalDependencies::class)
    fun bindHomeFeatureExternalDeps(appComponent: AppComponent): FeatureExternalDeps

    @Binds
    @IntoMap
    @FeatureExternalDepsKey(ProfileExternalDependencies::class)
    fun bindProfileFeatureExternalDeps(appComponent: AppComponent): FeatureExternalDeps

    @Binds
    @IntoMap
    @FeatureExternalDepsKey(DetailsExternalDependencies::class)
    fun bindDetailsFeatureExternalDeps(appComponent: AppComponent): FeatureExternalDeps

    @Binds
    @IntoMap
    @FeatureExternalDepsKey(FavoriteExternalDependencies::class)
    fun bindFavoriteFeatureExternalDeps(appComponent: AppComponent): FeatureExternalDeps

    @Binds
    @IntoMap
    @FeatureExternalDepsKey(EntryExternalDependencies::class)
    fun bindEntryFeatureExternalDeps(appComponent: AppComponent): FeatureExternalDeps
}