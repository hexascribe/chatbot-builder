package impl

import ChatBot
import androidx.compose.ui.window.ComposeUIViewController
import chat.model.ChatDefaults
import chat.screen.ChatScreen
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
