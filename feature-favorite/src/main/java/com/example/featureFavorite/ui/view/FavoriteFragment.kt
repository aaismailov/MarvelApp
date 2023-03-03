package com.example.featureFavorite.ui.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core.viewModel
import com.example.coreDi.dependency.findFeatureExternalDeps
import com.example.coreDi.vm.ViewModelFactory
import com.example.coreLocal.data.room.CharacterMapper
import com.example.featureFavorite.databinding.FavoriteFragmentBinding
import com.example.featureFavorite.ui.vm.FavoriteFeatureComponentDependenciesProvider
import com.example.featureFavorite.ui.vm.FavoriteFeatureComponentViewModel
import com.example.featureFavorite.ui.vm.FavoriteViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: FavoriteViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FavoriteFragmentBinding
    private lateinit var adapter: FavoriteAdapter

    override fun onAttach(context: Context) {
        FavoriteFeatureComponentDependenciesProvider.featureDependencies =
            findFeatureExternalDeps()
        viewModel<FavoriteFeatureComponentViewModel>().component.inject(this)

        super.onAttach(context)
    }

    private fun onClick(characterId: Int) {
        val uri = Uri.parse("App://Details/$characterId")
        findNavController().navigate(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        adapter = FavoriteAdapter(viewModel, ::onClick)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getFavCharacters().collect {
                    adapter.submitList(CharacterMapper().mapListEntityToListDto(it))

                    if (it.isEmpty()) {
                        binding.emptyText.visibility = View.VISIBLE
                    } else {
                        binding.emptyText.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }
}