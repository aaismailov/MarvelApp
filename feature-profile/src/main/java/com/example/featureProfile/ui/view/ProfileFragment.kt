package com.example.featureProfile.ui.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.core.Constants.ThemeConstants.DARK
import com.example.core.Constants.ThemeConstants.LIGHT
import com.example.core.viewModel
import com.example.coreDi.dependency.findFeatureExternalDeps
import com.example.coreDi.vm.ViewModelFactory
import com.example.featureProfile.databinding.ProfileFragmentBinding
import com.example.featureProfile.di.ProfileNavigation
import com.example.featureProfile.ui.vm.ProfileFeatureComponentDependenciesProvider
import com.example.featureProfile.ui.vm.ProfileFeatureComponentViewModel
import com.example.featureProfile.ui.vm.ProfileViewModel
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ProfileViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ProfileFragmentBinding

    @Inject
    lateinit var navigation: ProfileNavigation
    override fun onAttach(context: Context) {
        ProfileFeatureComponentDependenciesProvider.featureDependencies =
            findFeatureExternalDeps()
        viewModel<ProfileFeatureComponentViewModel>().component.inject(this)

        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)

        initTheme()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (binding) {
            nicknameField.text = viewModel.nickName.value
            logoutButton.setOnClickListener {
                val uri = Uri.parse("App://Entry")
                Navigation.findNavController(requireActivity(), navigation.navFrag).navigate(uri)
            }
            lightChip.setOnClickListener {
                setTheme(LIGHT)
                initTheme()
            }
            darkChip.setOnClickListener {
                setTheme(DARK)
                initTheme()
            }
        }
    }

    private fun initTheme() {
        when (viewModel.theme.value) {
            LIGHT -> {
                binding.chipGroup.check(binding.lightChip.id)
            }
            DARK -> {
                binding.chipGroup.check(binding.darkChip.id)
            }
        }
    }

    private fun setTheme(theme: String) {
        when (theme) {
            LIGHT -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            DARK -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
        viewModel.setTheme(theme)
    }
}