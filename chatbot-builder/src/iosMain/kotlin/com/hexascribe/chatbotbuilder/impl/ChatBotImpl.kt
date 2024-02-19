package com.hexascribe.chatbotbuilder.impl

import androidx.compose.ui.window.ComposeUIViewController
import com.hexascribe.chatbotbuilder.ChatBot
import com.hexascribe.chatbotbuilder.di.SdkModule
import com.hexascribe.chatbotbuilder.presentation.model.ChatDefaults
import com.hexascribe.chatbotbuilder.presentation.screen.ChatScreen
import org.koin.core.KoinApplication
import platform.UIKit.UIViewController

internal class ChatBotImpl(
    apiKey: String,
    private val chatDefaults: ChatDefaults
) : ChatBot() {

    private val koinApp = KoinApplication.init()

    init {
        val module = SdkModule.getModule(apiKey, chatDefaults.isLogErrorEnabled)
        koinApp.modules(module)
    }

    override fun getViewController(): UIViewController {
        return ComposeUIViewController {
            ChatScreen(koinApp.koin, chatDefaults = chatDefaults)
        }
    }
}
