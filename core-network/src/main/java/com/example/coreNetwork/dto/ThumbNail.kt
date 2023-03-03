package com.example.coreNetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThumbNail(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
)