package com.example.featureEntry.ui.vm

import androidx.lifecycle.ViewModel
import com.example.coreLocal.state.Session
import javax.inject.Inject

class EntryViewModel @Inject constructor(
    private val session: Session
) : ViewModel() {

    val nickName by lazy { session.nickName }

    fun setNickName(newNickName: String) = session.setNickName(newNickName)
}