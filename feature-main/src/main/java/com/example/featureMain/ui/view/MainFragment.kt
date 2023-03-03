package com.example.featureMain.ui.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.coreDi.dependency.findFeatureExternalDeps
import com.example.core.viewModel
import com.example.featureMain.R
import com.example.featureMain.databinding.FragmentMainBinding
import com.example.featureMain.ui.vm.MainFeatureComponentDependenciesProvider
import com.example.featureMain.ui.vm.MainFeatureComponentViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainFeatureComponentDependenciesProvider.featureDependencies = findFeatureExternalDeps()
        viewModel<MainFeatureComponentViewModel>().component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = (childFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment).navController
        binding.mainFragmentBottomNavigation.setupWithNavController(navController)
    }
}
