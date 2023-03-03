package com.example.coreNetwork

import com.example.coreNetwork.domain.repos.INetworkRepository
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val marvelApi: ApiService
) : INetworkRepository {
    override suspend fun getList() = marvelApi.getAllCharacters()

    override suspend fun searchCharacter(query: String) = marvelApi.searchCharacter(query)

    override suspend fun getComicsById(characterId: String) = marvelApi.getComicsById(characterId)

    override suspend fun getSeriesById(characterId: String) = marvelApi.getSeriesById(characterId)
}