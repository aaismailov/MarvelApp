package com.example.featureEntry.ui.vm

import androidx.lifecycle.ViewModel
import com.example.featureEntry.di.DaggerEntryComponent
import com.example.featureEntry.di.EntryExternalDependencies
import com.example.featureEntry.ui.vm.EntryFeatureComponentDependenciesProvider.featureDependencies

class EntryFeatureComponentViewModel : ViewModel() {
    val component by lazy {
        DaggerEntryComponent.factory()
            .create(checkNotNull(featureDependencies))
    }

    override fun onCleared() {
        super.onCleared()
        featureDependencies = null
    }
}

object EntryFeatureComponentDependenciesProvider {
    var featureDependencies: EntryExternalDependencies? = null
}