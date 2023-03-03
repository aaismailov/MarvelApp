package com.example.featureHome.ui.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
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
import com.example.featureHome.R
import com.example.featureHome.databinding.HomeFragmentBinding
import com.example.featureHome.ui.vm.HomeFeatureComponentDependenciesProvider
import com.example.featureHome.ui.vm.HomeFeatureComponentViewModel
import com.example.featureHome.ui.vm.HomeViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapter: HomeAdapter

    override fun onAttach(context: Context) {
        HomeFeatureComponentDependenciesProvider.featureDependencies =
            findFeatureExternalDeps()
        viewModel<HomeFeatureComponentViewModel>().component.inject(this)

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
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        adapter = HomeAdapter(viewModel, ::onClick)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchQuery.collect {
                    adapter.submitList(it)
                    if (it.isEmpty()) {
                        binding.progressBar.visibility = View.VISIBLE
                    } else {
                        binding.progressBar.visibility = View.INVISIBLE
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getFavCharacters().collect {
                    adapter.updateFavourites(CharacterMapper().mapListEntityToListDto(it))
                }
            }
        }

        binding.toolbar.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu)
                val searchItem = menu.findItem(R.id.character_search)
                val searchView = searchItem.actionView as SearchView

                searchView.queryHint = "Search Character"
                searchView.setIconifiedByDefault(false)
                searchView.onActionViewExpanded()

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        if (newText != null) {
                            viewModel.searchCharacter(newText)
                        }
                        return true
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.character_search -> {
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}