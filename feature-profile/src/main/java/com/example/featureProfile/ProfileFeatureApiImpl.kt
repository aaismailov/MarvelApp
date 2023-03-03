package com.example.featureProfile

import androidx.fragment.app.Fragment
import com.example.featureProfile.ui.view.ProfileFragment
import com.example.featureProfileApi.ProfileFeatureApi
import javax.inject.Inject

class ProfileFeatureApiImpl @Inject constructor(): ProfileFeatureApi {
    override fun getFlowFragment(): Fragment = ProfileFragment()
}