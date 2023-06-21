package com.arstechna.chatbotbuilder.chat.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.arstechna.chatbotbuilder.base.RoleEnum
import com.arstechna.chatbotbuilder.chat.model.ChatDefaults
import com.arstechna.chatbotbuilder.chat.model.MessageType
import co.yml.ychat.YChat
import co.yml.ychat.entrypoint.features.ChatCompletions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Stable
internal class ChatState(
    private val chatDefaults: ChatDefaults,
    private val yChat: YChat,
    private val coroutineScope: CoroutineScope
) {

    val message = mutableStateOf("")

    val messages = mutableStateListOf<MessageType>()

    val onButtonVisible = mutableStateOf(message.value.isNotEmpty())

    private val chatCompletions: ChatCompletions

    init {
        setupChatMessages()
        chatCompletions = createChatCompletions()
    }

    fun onMessage(message: String) {
        this.message.value = message
        verifyButtonVisible()
    }

    fun onTryAgain(message: String) {
        onError(false)
        this.message.value = message
        sendMessage()
    }

    fun sendMessage() = coroutineScope.launch {
        val messageToSend = message.value
        messages.add(MessageType.User(message.value))
        onLoading(true)
        onMessage("")
        runCatching { chatCompletions.execute(messageToSend) }
            .also { onLoading(false) }
            .onSuccess { messages.add(MessageType.Bot(it.first().content)) }
            .onFailure { onError(true) }
    }

    private fun onLoading(isLoading: Boolean) {
        if (isLoading) {
            onError(false)
            messages.add(MessageType.Loading)
        } else {
            messages.remove(MessageType.Loading)
        }
        verifyButtonVisible()
    }

    private fun onError(isError: Boolean) {
        if (isError) {
            val error = messages.removeLast() as? MessageType.User ?: return
            error.isError = true
            messages.add(error)
        } else {
            messages.removeAll { it is MessageType.User && it.isError }
        }
    }

    private fun createChatCompletions(): ChatCompletions {
        val chatCompletions = yChat
            .chatCompletions()
            .setMaxTokens(chatDefaults.maxTokens)
        chatDefaults.preSeededMessages.forEach {
            chatCompletions.addMessage(it.role, it.content)
        }
        return chatCompletions
    }

    private fun setupChatMessages() {
        val chatMessages = chatDefaults.messages.mapNotNull {
            if (RoleEnum.isAssistant(it.role)) MessageType.Bot(it.content)
            else if (RoleEnum.isUser(it.role)) MessageType.User(it.content)
            else null
        }
        this.messages.addAll(chatMessages)
    }

    private fun verifyButtonVisible() {
        onButtonVisible.value = this.message.value.isNotEmpty()
                && !messages.contains(MessageType.Loading)
    }
}
