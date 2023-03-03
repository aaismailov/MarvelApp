package com.example.featureHome.di

import androidx.lifecycle.ViewModel
import com.example.coreDi.vm.ViewModelKey
import com.example.featureHome.ui.vm.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeBindsModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}