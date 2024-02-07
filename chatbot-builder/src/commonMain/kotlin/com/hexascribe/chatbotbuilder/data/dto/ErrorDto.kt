package com.hexascribe.chatbotbuilder.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ErrorDto(
    @SerialName("error") val error: ErrorDetailsDto,
)
