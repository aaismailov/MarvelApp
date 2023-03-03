package com.example.featureEntry.ui.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.viewModel
import com.example.coreDi.dependency.findFeatureExternalDeps
import com.example.coreDi.vm.ViewModelFactory
import com.example.featureEntry.databinding.EntryFragmentBinding
import com.example.featureEntry.ui.vm.EntryFeatureComponentDependenciesProvider
import com.example.featureEntry.ui.vm.EntryFeatureComponentViewModel
import com.example.featureEntry.ui.vm.EntryViewModel
import javax.inject.Inject

class EntryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EntryViewModel by viewModels { viewModelFactory }

    private lateinit var binding: EntryFragmentBinding

    override fun onAttach(context: Context) {
        EntryFeatureComponentDependenciesProvider.featureDependencies =
            findFeatureExternalDeps()
        viewModel<EntryFeatureComponentViewModel>().component.inject(this)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EntryFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.entryField.setText(viewModel.nickName.value)
        binding.entryButton.setOnClickListener {
            viewModel.setNickName(binding.entryField.text.toString())
            val uri = Uri.parse("App://Main")
            findNavController().navigate(uri)
        }
    }
}