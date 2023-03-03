package com.example.featureProfile.di

import androidx.annotation.IdRes

interface ProfileNavigation {
    @get:IdRes
    val navFrag: Int
}