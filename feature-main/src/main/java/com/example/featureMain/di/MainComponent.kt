package com.example.featureMain.di

import com.example.coreDi.scope.FeatureScope
import com.example.featureMain.ui.view.MainFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [MainFeatureApiModule::class],
    dependencies = [MainExternalDependencies::class]
)
interface MainComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: MainExternalDependencies): MainComponent
    }

    fun inject(mainFragment: MainFragment)
}