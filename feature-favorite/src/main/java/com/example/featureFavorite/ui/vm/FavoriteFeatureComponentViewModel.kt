package com.example.featureFavorite.ui.vm

import androidx.lifecycle.ViewModel
import com.example.featureFavorite.di.DaggerFavoriteComponent
import com.example.featureFavorite.di.FavoriteExternalDependencies
import com.example.featureFavorite.ui.vm.FavoriteFeatureComponentDependenciesProvider.featureDependencies

class FavoriteFeatureComponentViewModel : ViewModel() {
    val component by lazy {
        DaggerFavoriteComponent.factory()
            .create(checkNotNull(featureDependencies))
    }

    override fun onCleared() {
        super.onCleared()
        featureDependencies = null
    }
}

object FavoriteFeatureComponentDependenciesProvider {
    var featureDependencies: FavoriteExternalDependencies? = null
}