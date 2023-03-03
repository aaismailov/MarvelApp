package com.example.coreNetwork.domain.repos

import com.example.coreNetwork.dto.CharacterResponse
import com.example.coreNetwork.dto.ComicsResponse
import com.example.coreNetwork.dto.SeriesResponse

interface INetworkRepository {
    suspend fun getList(): CharacterResponse
    suspend fun searchCharacter(query: String): CharacterResponse
    suspend fun getComicsById(characterId: String): ComicsResponse
    suspend fun getSeriesById(characterId: String): SeriesResponse
}