package com.example.featureMain

import androidx.fragment.app.Fragment
import com.example.featureMain.ui.view.MainFragment
import com.example.featureMainApi.MainFeatureApi
import javax.inject.Inject

class MainFeatureApiImpl @Inject constructor(): MainFeatureApi {
    override fun getFlowFragment(): Fragment = MainFragment()
}