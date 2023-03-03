package com.example.coreLocal.domain.repos

import com.example.coreLocal.data.room.CharacterEntity
import com.example.coreNetwork.dto.Character
import kotlinx.coroutines.flow.Flow

interface ILocalRepository {

    suspend fun addCharacterToFavourite(character: Character)

    suspend fun removeCharacterFromFavourite(character: Character)

    suspend fun getFavCharacters(): Flow<List<CharacterEntity>>
}