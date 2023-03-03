package com.example.featureDetails.ui.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.viewModel
import com.example.coreDi.dependency.findFeatureExternalDeps
import com.example.coreDi.vm.ViewModelFactory
import com.example.featureDetails.databinding.DetailsFragmentBinding
import com.example.featureDetails.ui.view.comics.ComicsAdapter
import com.example.featureDetails.ui.view.series.SeriesAdapter
import com.example.featureDetails.ui.vm.DetailsFeatureComponentDependenciesProvider
import com.example.featureDetails.ui.vm.DetailsFeatureComponentViewModel
import com.example.featureDetails.ui.vm.DetailsViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }
    private val navArgs by navArgs<DetailsFragmentArgs>()

    private lateinit var binding: DetailsFragmentBinding

    private lateinit var comicsAdapter: ComicsAdapter
    private lateinit var seriesAdapter: SeriesAdapter

    override fun onAttach(context: Context) {
        DetailsFeatureComponentDependenciesProvider.featureDependencies =
            findFeatureExternalDeps()
        viewModel<DetailsFeatureComponentViewModel>().component.inject(this)
        viewModel.setCharacterId(navArgs.characterId.toString())

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        comicsAdapter = ComicsAdapter()
        seriesAdapter = SeriesAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStackImmediate()
        }
        binding.comicsRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.comicsRecycler.adapter = comicsAdapter
        binding.seriesRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.seriesRecycler.adapter = seriesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.comicsList.collect {
                    comicsAdapter.submitList(it)
                    if (it.isEmpty()) { //I know...
                        binding.progressBarComics.visibility = View.VISIBLE
                    } else {
                        binding.progressBarComics.visibility = View.INVISIBLE
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.seriesList.collect {
                    seriesAdapter.submitList(it)
                    if (it.isEmpty()) {
                        binding.progressBarSeries.visibility = View.VISIBLE
                    } else {
                        binding.progressBarSeries.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }
}