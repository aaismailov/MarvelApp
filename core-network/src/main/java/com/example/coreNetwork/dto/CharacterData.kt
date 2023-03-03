package com.example.coreNetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterData(
    @SerialName("results")
    val results: List<Character>
)
