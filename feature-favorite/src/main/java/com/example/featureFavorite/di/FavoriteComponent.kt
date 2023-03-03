package com.example.featureFavorite.di

import com.example.coreDi.scope.FeatureScope
import com.example.featureFavorite.ui.view.FavoriteFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FavoriteBindsModule::class,
        FavoriteFeatureApiModule::class
    ],
    dependencies = [FavoriteExternalDependencies::class]
)
interface FavoriteComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: FavoriteExternalDependencies): FavoriteComponent
    }

    fun inject(favoriteFragment: FavoriteFragment)
}