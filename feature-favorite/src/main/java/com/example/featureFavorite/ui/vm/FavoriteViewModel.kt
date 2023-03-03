package com.example.featureFavorite.ui.vm

import androidx.lifecycle.ViewModel
import com.example.coreLocal.data.LocalRepository
import com.example.coreNetwork.dto.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val localRepo: LocalRepository
) : ViewModel() {

    suspend fun getFavCharacters() = localRepo.getFavCharacters()

    fun removeFromFavourite(characterResult: Character) =
        CoroutineScope(Dispatchers.IO).launch {
            localRepo.removeCharacterFromFavourite(characterResult)
        }
}