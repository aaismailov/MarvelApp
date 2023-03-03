package com.example.project.dagger.navigation

import com.example.featureProfile.di.ProfileNavigation
import com.example.project.R
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {
    @Provides
    fun provideProfileNavigation(): ProfileNavigation {
        return object : ProfileNavigation {
            override val navFrag = R.id.nav_frag
        }
    }
}