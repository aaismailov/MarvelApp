package com.example.project.ui

import androidx.lifecycle.ViewModel
import com.example.project.MarvelApp
import com.example.project.dagger.AppComponent
import com.example.coreLocal.state.Session
import javax.inject.Inject

class MainViewModel(appComponent: AppComponent = MarvelApp.appComponent) : ViewModel() {

    @Inject
    lateinit var session: Session

    val theme by lazy { session.theme }

    init {
        appComponent.inject(this)
    }
}