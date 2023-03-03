package com.example.featureEntry.di

import android.content.Context
import com.example.coreDi.dependency.FeatureExternalDeps
import com.example.coreLocal.state.Session

interface EntryExternalDependencies : FeatureExternalDeps {
    val context: Context
    val session: Session
}