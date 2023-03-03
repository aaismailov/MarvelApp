package com.example.featureDetails.ui.vm

import androidx.lifecycle.ViewModel
import com.example.featureDetails.di.DaggerDetailsComponent
import com.example.featureDetails.di.DetailsExternalDependencies
import com.example.featureDetails.ui.vm.DetailsFeatureComponentDependenciesProvider.featureDependencies

class DetailsFeatureComponentViewModel : ViewModel() {
    val component by lazy {
        DaggerDetailsComponent.factory()
            .create(checkNotNull(featureDependencies))
    }

    override fun onCleared() {
        super.onCleared()
        featureDependencies = null
    }
}

object DetailsFeatureComponentDependenciesProvider {
    var featureDependencies: DetailsExternalDependencies? = null
}