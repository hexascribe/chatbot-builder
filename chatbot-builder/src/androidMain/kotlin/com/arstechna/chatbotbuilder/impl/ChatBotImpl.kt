package com.arstechna.chatbotbuilder.impl

import androidx.compose.runtime.Composable
import com.arstechna.chatbotbuilder.ChatBot
import com.arstechna.chatbotbuilder.chat.model.ChatDefaults

internal class ChatBotImpl(
    private val apiKey: String,
    private val chatDefaults: ChatDefaults
) : ChatBot() {

    @Composable
    override fun ChatScreen() {
        com.arstechna.chatbotbuilder.chat.screen.ChatScreen(apiKey, chatDefaults = chatDefaults)
    }
}
