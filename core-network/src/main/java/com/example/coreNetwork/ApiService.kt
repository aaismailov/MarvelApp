package com.example.coreNetwork

import com.example.coreNetwork.dto.CharacterResponse
import com.example.coreNetwork.dto.ComicsResponse
import com.example.coreNetwork.dto.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    suspend fun getAllCharacters(
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20
    ): CharacterResponse

    @GET("characters")
    suspend fun searchCharacter(
        @Query("nameStartsWith") query: String,
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20
    ): CharacterResponse

    @GET("characters/{characterId}/comics")
    suspend fun getComicsById(
        @Path("characterId") characterId: String,
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20
    ): ComicsResponse

    @GET("characters/{characterId}/series")
    suspend fun getSeriesById(
        @Path("characterId") characterId: String,
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20
    ): SeriesResponse
}