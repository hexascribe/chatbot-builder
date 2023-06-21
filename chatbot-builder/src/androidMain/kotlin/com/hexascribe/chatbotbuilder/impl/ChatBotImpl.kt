package com.hexascribe.chatbotbuilder.impl

import androidx.compose.runtime.Composable
import com.hexascribe.chatbotbuilder.ChatBot
import com.hexascribe.chatbotbuilder.chat.model.ChatDefaults

internal class ChatBotImpl(
    private val apiKey: String,
    private val chatDefaults: ChatDefaults
) : ChatBot() {

    @Composable
    override fun ChatScreen() {
        com.hexascribe.chatbotbuilder.chat.screen.ChatScreen(apiKey, chatDefaults = chatDefaults)
    }
}
