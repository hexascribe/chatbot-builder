package com.hexascribe.chatbotbuilder.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MessageDto(
    @SerialName("role") val role: String,
    @SerialName("content") val content: String,
)
