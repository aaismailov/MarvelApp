package com.example.featureProfile.ui.vm

import androidx.lifecycle.ViewModel
import com.example.coreLocal.state.Session
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val session: Session
) : ViewModel() {

    val theme by lazy { session.theme }
    val nickName by lazy { session.nickName }

    fun setTheme(newTheme: String) = session.setTheme(newTheme)
}