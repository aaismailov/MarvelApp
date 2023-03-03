package com.example.featureFavorite.di

import androidx.lifecycle.ViewModel
import com.example.coreDi.vm.ViewModelKey
import com.example.featureFavorite.ui.vm.FavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FavoriteBindsModule {
    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel
}