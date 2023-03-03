package com.example.featureProfile.di

import android.content.Context
import com.example.coreDi.dependency.FeatureExternalDeps
import com.example.coreLocal.data.room.CharacterDao
import com.example.coreLocal.state.Session

interface ProfileExternalDependencies : FeatureExternalDeps {
    val context: Context
    val characterDao: CharacterDao
    val session: Session
    val profileNavigation: ProfileNavigation
}