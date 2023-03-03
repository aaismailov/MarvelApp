package com.example.featureDetails.di

import android.content.Context
import com.example.coreDi.dependency.FeatureExternalDeps
import com.example.coreNetwork.ApiService

interface DetailsExternalDependencies : FeatureExternalDeps {
    val context: Context
    val apiService: ApiService
}