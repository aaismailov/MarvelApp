package com.example.featureProfile.di

import com.example.coreDi.scope.FeatureScope
import com.example.featureProfile.ui.view.ProfileFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        ProfileBindsModule::class,
        ProfileFeatureApiModule::class
    ],
    dependencies = [ProfileExternalDependencies::class]
)
interface ProfileComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: ProfileExternalDependencies): ProfileComponent
    }

    fun inject(profileFragment: ProfileFragment)
}