package com.example.project.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import com.example.coreDi.dependency.FeatureExternalDepsContainer
import com.example.coreDi.dependency.FeatureExternalDepsProvider
import com.example.project.MarvelApp.Companion.appComponent
import com.example.project.R
import com.example.core.Constants.ThemeConstants.DARK
import com.example.core.Constants.ThemeConstants.LIGHT
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main), FeatureExternalDepsProvider {

    @Inject
    override lateinit var deps: FeatureExternalDepsContainer

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        initTheme()
    }

    private fun initTheme() {
        when (viewModel.theme.value) {
            LIGHT -> {
                setDefaultNightMode(MODE_NIGHT_NO)
            }
            DARK -> {
                setDefaultNightMode(MODE_NIGHT_YES)
            }
        }
    }
}