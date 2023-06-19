package impl

import ChatBot
import androidx.compose.runtime.Composable
import chat.model.ChatDefaults

internal class ChatBotImpl(
    private val apiKey: String,
    private val chatDefaults: ChatDefaults
) : ChatBot() {

    @Composable
    override fun ChatScreen() {
        chat.screen.ChatScreen(apiKey, chatDefaults = chatDefaults)
    }
}
