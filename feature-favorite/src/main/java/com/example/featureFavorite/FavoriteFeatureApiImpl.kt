package com.example.featureFavorite

import androidx.fragment.app.Fragment
import com.example.featureFavorite.ui.view.FavoriteFragment
import com.example.featureFavoriteApi.FavoriteFeatureApi
import javax.inject.Inject

class FavoriteFeatureApiImpl @Inject constructor(): FavoriteFeatureApi {
    override fun getFlowFragment(): Fragment = FavoriteFragment()
}