package com.hexascribe.chatbotbuilder.domain.model

import com.hexascribe.chatbotbuilder.core.enums.RoleEnum

internal data class ChatMessageModel(
    val role: RoleEnum,
    val content: String,
)
