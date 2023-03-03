package com.example.featureMain.ui.vm

import androidx.lifecycle.ViewModel
import com.example.featureMain.di.DaggerMainComponent
import com.example.featureMain.di.MainExternalDependencies
import com.example.featureMain.ui.vm.MainFeatureComponentDependenciesProvider.featureDependencies

class MainFeatureComponentViewModel : ViewModel() {
    val component by lazy {
        DaggerMainComponent.factory()
            .create(checkNotNull(featureDependencies))
    }

    override fun onCleared() {
        super.onCleared()
        featureDependencies = null
    }
}

object MainFeatureComponentDependenciesProvider {
    var featureDependencies: MainExternalDependencies? = null
}