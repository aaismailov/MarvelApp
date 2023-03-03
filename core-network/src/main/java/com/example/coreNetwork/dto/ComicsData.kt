package com.example.coreNetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicsData(
    @SerialName("results")
    val results: List<Comics>
)
