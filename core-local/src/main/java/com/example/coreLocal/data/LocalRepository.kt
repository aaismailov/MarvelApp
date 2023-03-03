package com.example.coreLocal.data

import com.example.coreLocal.data.room.CharacterDao
import com.example.coreLocal.domain.repos.ILocalRepository
import com.example.coreNetwork.dto.Character
import com.example.coreLocal.data.room.CharacterEntity
import com.example.coreLocal.data.room.CharacterMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val characterDao: CharacterDao
) : ILocalRepository {

    private var mapper = CharacterMapper()

    override suspend fun addCharacterToFavourite(character: Character) =
        characterDao.insert(mapper.mapDtoToEntity(character))

    override suspend fun removeCharacterFromFavourite(character: Character) =
        characterDao.delete(mapper.mapDtoToEntity(character))

    override suspend fun getFavCharacters(): Flow<List<CharacterEntity>> =
        characterDao.getFavCharacters()
}