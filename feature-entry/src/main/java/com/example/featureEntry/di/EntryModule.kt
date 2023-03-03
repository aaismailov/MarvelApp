package com.example.featureEntry.di

import androidx.lifecycle.ViewModel
import com.example.coreDi.vm.ViewModelKey
import com.example.featureEntry.ui.vm.EntryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface EntryBindsModule {
    @Binds
    @IntoMap
    @ViewModelKey(EntryViewModel::class)
    fun bindEntryViewModel(viewModel: EntryViewModel): ViewModel
}