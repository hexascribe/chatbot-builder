package com.hexascribe.chatbotbuilder.presentation.model

internal sealed class MessageType {
    data class User(val text: String, var isError: Boolean = false): MessageType()
    data class Bot(val text: String): MessageType()
    data object Loading: MessageType()
}
