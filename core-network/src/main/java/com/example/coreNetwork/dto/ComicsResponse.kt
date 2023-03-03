package com.example.coreNetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicsResponse(
    @SerialName("data")
    val data: ComicsData
)
