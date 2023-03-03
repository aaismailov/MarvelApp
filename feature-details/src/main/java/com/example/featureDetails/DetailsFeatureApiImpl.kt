package com.example.featureDetails

import androidx.fragment.app.Fragment
import com.example.featureDetails.ui.view.DetailsFragment
import com.example.featureDetailsApi.DetailsFeatureApi
import javax.inject.Inject

class DetailsFeatureApiImpl @Inject constructor(): DetailsFeatureApi {
    override fun getFlowFragment(): Fragment = DetailsFragment()
}