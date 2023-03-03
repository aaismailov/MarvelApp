package com.example.featureDetails.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coreNetwork.NetworkRepository
import com.example.coreNetwork.dto.Comics
import com.example.coreNetwork.dto.Series
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val networkRepo: NetworkRepository
) : ViewModel() {

    private val _comicsList: MutableStateFlow<List<Comics>> = MutableStateFlow(emptyList())
    val comicsList: StateFlow<List<Comics>> = _comicsList

    private val _seriesList: MutableStateFlow<List<Series>> = MutableStateFlow(emptyList())
    val seriesList: StateFlow<List<Series>> = _seriesList

    fun setCharacterId(characterId: String) {
        getComicsById(characterId)
        getSeriesById(characterId)
    }

    private fun getComicsById(characterId: String) = viewModelScope.launch {
        _comicsList.value = networkRepo.getComicsById(characterId).data.results
    }

    private fun getSeriesById(characterId: String) = viewModelScope.launch {
        _seriesList.value = networkRepo.getSeriesById(characterId).data.results
    }
}