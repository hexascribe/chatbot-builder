package com.hexascribe.chatbotbuilder.domain.usecase

import com.hexascribe.chatbotbuilder.data.api.OpenAiApi
import com.hexascribe.chatbotbuilder.domain.converter.SendChatMessageDtoConverter
import com.hexascribe.chatbotbuilder.domain.model.ChatMessageModel

internal class SendChatMessageUseCase(
    private val openAiApi: OpenAiApi,
    private val sendChatMessageDtoConverter: SendChatMessageDtoConverter,
) {

    suspend fun execute(
        maxTokens: Int,
        preSeededMessages: List<ChatMessageModel>,
        messageToSend: String,
    ): Result<String> {
        val sendChatMessageDto =
            sendChatMessageDtoConverter.generate(maxTokens, preSeededMessages, messageToSend)
        val result = openAiApi.sendMessage(sendChatMessageDto)

        return if (result.isSuccess) {
            val messageContent = result.getOrNull()?.choices?.first()?.message?.content.orEmpty()
            Result.success(messageContent)
        } else {
            val exception =
                result.exceptionOrNull() ?: IllegalStateException("Failed to send chat message")
            Result.failure(exception)
        }
    }
}
