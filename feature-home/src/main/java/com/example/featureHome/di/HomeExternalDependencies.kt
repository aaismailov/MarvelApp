package com.example.featureHome.di

import android.content.Context
import com.example.coreDi.dependency.FeatureExternalDeps
import com.example.coreLocal.data.room.CharacterDao
import com.example.coreNetwork.ApiService

interface HomeExternalDependencies : FeatureExternalDeps {
    val context: Context
    val characterDao: CharacterDao
    val apiService: ApiService
}