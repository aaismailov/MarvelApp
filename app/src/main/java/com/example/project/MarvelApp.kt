package com.example.project

import android.app.Application
import com.example.project.dagger.AppComponent
import com.example.project.dagger.DaggerAppComponent

class MarvelApp  : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}