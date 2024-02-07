package com.hexascribe.chatbotbuilder.domain.converter

import com.hexascribe.chatbotbuilder.core.enums.RoleEnum
import com.hexascribe.chatbotbuilder.data.dto.MessageDto
import com.hexascribe.chatbotbuilder.data.dto.SendChatMessageDto
import com.hexascribe.chatbotbuilder.domain.model.ChatMessageModel

internal class SendChatMessageDtoConverter {

    fun generate(
        maxTokens: Int,
        preSeededMessages: List<ChatMessageModel>,
        messageToSend: String,
    ): SendChatMessageDto {
        val messageToSendDto =
            MessageDto(role = RoleEnum.USER.name.lowercase(), content = messageToSend)
        val messagesDto = preSeededMessages
            .map { MessageDto(role = it.role.name.lowercase(), content = it.content) }
            .toMutableList()
            .apply { add(messageToSendDto) }
        return SendChatMessageDto(
            model = "gpt-3.5-turbo",
            messages = messagesDto,
            maxTokens = maxTokens,
        )
    }
}
