package com.hexascribe.chatbotbuilder.impl

import androidx.compose.ui.window.ComposeUIViewController
import com.hexascribe.chatbotbuilder.ChatBot
import com.hexascribe.chatbotbuilder.chat.model.ChatDefaults
import com.hexascribe.chatbotbuilder.chat.screen.ChatScreen
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
