package com.example.coreNetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesResponse(
    @SerialName("data")
    val data: SeriesData
)
