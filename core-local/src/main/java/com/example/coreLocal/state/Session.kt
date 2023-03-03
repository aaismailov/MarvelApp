package com.example.coreLocal.state

import android.content.Context
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class Session @Inject constructor(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    private val _theme = MutableStateFlow(sharedPreferences.getString(PREF_THEME, "").orEmpty())
    val theme: StateFlow<String> = _theme

    private val _nickName = MutableStateFlow(sharedPreferences.getString(PREF_NICKNAME, "").orEmpty())
    val nickName: StateFlow<String> = _nickName

    fun setTheme(newTheme: String) {
        sharedPreferences.edit { putString(PREF_THEME, newTheme) }
        _theme.value = newTheme
    }

    fun setNickName(newNickName: String) {
        sharedPreferences.edit { putString(PREF_NICKNAME, newNickName) }
        _nickName.value = newNickName
    }

    companion object {
        const val PREF_NAME = "session"
        const val PREF_THEME = "theme"
        const val PREF_NICKNAME = "nickname"
    }
}