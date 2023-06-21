package com.arstechna.chatbotbuilder.impl

import androidx.compose.ui.window.ComposeUIViewController
import com.arstechna.chatbotbuilder.ChatBot
import com.arstechna.chatbotbuilder.chat.model.ChatDefaults
import com.arstechna.chatbotbuilder.chat.screen.ChatScreen
import platform.UIKit.UIViewController

internal class ChatBotImpl(
    private val apiKey: String,
    private val chatDefaults: ChatDefaults
) : ChatBot() {

    override fun getViewController(): UIViewController {
        return ComposeUIViewController {
            ChatScreen(
                apiKey = apiKey,
                chatDefaults = chatDefaults
            )
        }
    }
}
