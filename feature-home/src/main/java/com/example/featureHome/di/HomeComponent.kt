package com.example.featureHome.di

import com.example.coreDi.scope.FeatureScope
import com.example.featureHome.ui.view.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        HomeBindsModule::class,
        HomeFeatureApiModule::class
    ],
    dependencies = [HomeExternalDependencies::class]
)
interface HomeComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeExternalDependencies): HomeComponent
    }

    fun inject(homeFragment: HomeFragment)
}