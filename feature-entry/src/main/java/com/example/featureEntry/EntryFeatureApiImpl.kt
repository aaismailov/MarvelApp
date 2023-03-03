package com.example.featureEntry

import androidx.fragment.app.Fragment
import com.example.featureEntry.ui.view.EntryFragment
import com.example.featureEntryApi.EntryFeatureApi
import javax.inject.Inject

class EntryFeatureApiImpl @Inject constructor(): EntryFeatureApi {
    override fun getFlowFragment(): Fragment = EntryFragment()
}