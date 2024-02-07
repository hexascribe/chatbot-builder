package com.hexascribe.chatbotbuilder.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ChatMessageDto(
    @SerialName("id") val id: String,
    @SerialName("model") val model: String,
    @SerialName("choices") val choices: List<ChoiceDto>,
)
