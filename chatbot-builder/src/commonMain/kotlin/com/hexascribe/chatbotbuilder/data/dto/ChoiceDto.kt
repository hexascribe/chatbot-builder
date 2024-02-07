package com.hexascribe.chatbotbuilder.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ChoiceDto(
    @SerialName("index") val index: Int,
    @SerialName("message") val message: MessageDto,
)
