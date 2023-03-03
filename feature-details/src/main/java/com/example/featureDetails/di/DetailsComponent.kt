package com.example.featureDetails.di

import com.example.coreDi.scope.FeatureScope
import com.example.featureDetails.ui.view.DetailsFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        DetailsBindsModule::class,
        DetailsFeatureApiModule::class
    ],
    dependencies = [DetailsExternalDependencies::class]
)
interface DetailsComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: DetailsExternalDependencies): DetailsComponent
    }

    fun inject(homeFragment: DetailsFragment)
}