package com.example.featureHome.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coreLocal.data.LocalRepository
import com.example.coreNetwork.NetworkRepository
import com.example.coreNetwork.dto.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val localRepo: LocalRepository,
    private val networkRepo: NetworkRepository
) : ViewModel() {

    private val _searchQuery: MutableStateFlow<List<Character>> = MutableStateFlow(emptyList())
    val searchQuery: StateFlow<List<Character>> = _searchQuery

    init {
        searchCharacter()
    }

    fun searchCharacter(query: String = "") = viewModelScope.launch {
        if (query != "") {
            _searchQuery.value = networkRepo.searchCharacter(query).data.results
        } else {
            _searchQuery.value = networkRepo.getList().data.results
        }
    }

    suspend fun getFavCharacters() = localRepo.getFavCharacters()

    fun addToFavourite(characterResult: Character) =
        CoroutineScope(Dispatchers.IO).launch {
            localRepo.addCharacterToFavourite(characterResult)
        }

    fun removeFromFavourite(characterResult: Character) =
        CoroutineScope(Dispatchers.IO).launch {
            localRepo.removeCharacterFromFavourite(characterResult)
        }
}