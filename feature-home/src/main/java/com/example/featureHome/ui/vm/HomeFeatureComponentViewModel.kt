package com.example.featureHome.ui.vm

import androidx.lifecycle.ViewModel
import com.example.featureHome.di.DaggerHomeComponent
import com.example.featureHome.di.HomeExternalDependencies
import com.example.featureHome.ui.vm.HomeFeatureComponentDependenciesProvider.featureDependencies

class HomeFeatureComponentViewModel : ViewModel() {
    val component by lazy {
        DaggerHomeComponent.factory()
            .create(checkNotNull(featureDependencies))
    }

    override fun onCleared() {
        super.onCleared()
        featureDependencies = null
    }
}

object HomeFeatureComponentDependenciesProvider {
    var featureDependencies: HomeExternalDependencies? = null
}