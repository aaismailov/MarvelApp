package com.example.featureMain.di

import android.content.Context
import com.example.coreDi.dependency.FeatureExternalDeps

interface MainExternalDependencies : FeatureExternalDeps {
    val context: Context
}