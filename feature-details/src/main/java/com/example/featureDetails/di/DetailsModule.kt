package com.example.featureDetails.di

import androidx.lifecycle.ViewModel
import com.example.coreDi.vm.ViewModelKey
import com.example.featureDetails.ui.vm.DetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailsBindsModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindHomeViewModel(viewModel: DetailsViewModel): ViewModel
}