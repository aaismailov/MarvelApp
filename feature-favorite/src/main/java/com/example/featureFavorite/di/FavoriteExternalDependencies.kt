package com.example.featureFavorite.di

import android.content.Context
import com.example.coreDi.dependency.FeatureExternalDeps
import com.example.coreLocal.data.room.CharacterDao
import com.example.coreLocal.state.Session

interface FavoriteExternalDependencies : FeatureExternalDeps {
    val context: Context
    val characterDao: CharacterDao
}