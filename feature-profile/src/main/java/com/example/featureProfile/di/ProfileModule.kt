package com.example.featureProfile.di

import androidx.lifecycle.ViewModel
import com.example.coreDi.vm.ViewModelKey
import com.example.featureProfile.ui.vm.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ProfileBindsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}