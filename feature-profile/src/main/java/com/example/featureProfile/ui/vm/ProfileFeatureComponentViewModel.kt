package com.example.featureProfile.ui.vm

import androidx.lifecycle.ViewModel
import com.example.featureProfile.di.DaggerProfileComponent
import com.example.featureProfile.di.ProfileExternalDependencies
import com.example.featureProfile.ui.vm.ProfileFeatureComponentDependenciesProvider.featureDependencies

class ProfileFeatureComponentViewModel : ViewModel() {
    val component by lazy {
        DaggerProfileComponent.factory()
            .create(checkNotNull(featureDependencies))
    }

    override fun onCleared() {
        super.onCleared()
        featureDependencies = null
    }
}

object ProfileFeatureComponentDependenciesProvider {
    var featureDependencies: ProfileExternalDependencies? = null
}