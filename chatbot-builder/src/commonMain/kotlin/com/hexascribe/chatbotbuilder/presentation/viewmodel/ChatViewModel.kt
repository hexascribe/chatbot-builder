package com.hexascribe.chatbotbuilder.presentation.viewmodel

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.hexascribe.chatbotbuilder.core.enums.RoleEnum
import com.hexascribe.chatbotbuilder.domain.usecase.SendChatMessageUseCase
import com.hexascribe.chatbotbuilder.presentation.model.ChatDefaults
import com.hexascribe.chatbotbuilder.presentation.model.MessageType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Stable
internal class ChatViewModel(
    private val chatDefaults: ChatDefaults,
    private val coroutineScope: CoroutineScope,
    private val sendChatMessageUseCase: SendChatMessageUseCase,
) {

    val message = mutableStateOf("")

    val messages = mutableStateListOf<MessageType>()

    val onButtonVisible = mutableStateOf(message.value.isNotEmpty())

    init {
        setupChatMessages()
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

        sendChatMessageUseCase.execute(
            maxTokens = chatDefaults.maxTokens,
            preSeededMessages = chatDefaults.preSeededMessages,
            messageToSend = messageToSend,
        ).also { onLoading(false) }
            .onSuccess { messages.add(MessageType.Bot(it)) }
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

    private fun setupChatMessages() {
        val chatMessages = chatDefaults.messages.mapNotNull {
            when (it.role) {
                RoleEnum.ASSISTANT -> MessageType.Bot(it.content)
                RoleEnum.USER -> MessageType.User(it.content)
                else -> null
            }
        }
        this.messages.addAll(chatMessages)
    }

    private fun verifyButtonVisible() {
        onButtonVisible.value = this.message.value.isNotEmpty()
                && !messages.contains(MessageType.Loading)
    }
}
