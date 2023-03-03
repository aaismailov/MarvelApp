package com.example.featureHome

import androidx.fragment.app.Fragment
import com.example.featureHome.ui.view.HomeFragment
import com.example.featureHomeApi.HomeFeatureApi
import javax.inject.Inject

class HomeFeatureApiImpl @Inject constructor(): HomeFeatureApi {
    override fun getFlowFragment(): Fragment = HomeFragment()
}