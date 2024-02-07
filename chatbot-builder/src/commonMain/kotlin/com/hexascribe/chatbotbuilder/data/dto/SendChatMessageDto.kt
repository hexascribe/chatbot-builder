package com.hexascribe.chatbotbuilder.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SendChatMessageDto(
    @SerialName("model") val model: String,
    @SerialName("messages") val messages: List<MessageDto>,
    @SerialName("max_tokens") val maxTokens: Int,
)
