package com.example.project.dagger

import android.content.Context
import com.example.coreDi.scope.AppScope
import com.example.featureDetails.di.DetailsExternalDependencies
import com.example.featureEntry.di.EntryExternalDependencies
import com.example.featureFavorite.di.FavoriteExternalDependencies
import com.example.featureHome.di.HomeExternalDependencies
import com.example.featureMain.di.MainExternalDependencies
import com.example.featureProfile.di.ProfileExternalDependencies
import com.example.project.dagger.local.LocalProvidesModule
import com.example.project.dagger.navigation.NavigationModule
import com.example.project.dagger.network.NetworkProvidesModule
import com.example.project.ui.MainActivity
import com.example.project.ui.MainViewModel
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [
    AppModule::class,
    LocalProvidesModule::class,
    NetworkProvidesModule::class,
    RepositoriesModule::class,
    NavigationModule::class,
    FeatureExternalDepsModule::class
])
interface AppComponent :
    MainExternalDependencies,
    HomeExternalDependencies,
    ProfileExternalDependencies,
    DetailsExternalDependencies,
    FavoriteExternalDependencies,
    EntryExternalDependencies {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(activity: MainActivity)
    fun inject(mainViewModel: MainViewModel)
}