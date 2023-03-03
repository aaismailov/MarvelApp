package com.example.featureEntry.di

import com.example.coreDi.scope.FeatureScope
import com.example.featureEntry.ui.view.EntryFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        EntryBindsModule::class,
        EntryFeatureApiModule::class
    ],
    dependencies = [EntryExternalDependencies::class]
)
interface EntryComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: EntryExternalDependencies): EntryComponent
    }

    fun inject(profileFragment: EntryFragment)
}