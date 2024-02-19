package com.hexascribe.chatbotbuilder.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hexascribe.chatbotbuilder.presentation.components.BalloonBotMessage
import com.hexascribe.chatbotbuilder.presentation.components.BalloonBotTyping
import com.hexascribe.chatbotbuilder.presentation.components.BalloonUserMessage
import com.hexascribe.chatbotbuilder.presentation.components.SendInputField
import com.hexascribe.chatbotbuilder.presentation.model.ChatDefaults
import com.hexascribe.chatbotbuilder.presentation.model.MessageType
import com.hexascribe.chatbotbuilder.presentation.viewmodel.ChatViewModel
import org.koin.core.Koin

@Composable
internal fun ChatScreen(
    koin: Koin,
    chatDefaults: ChatDefaults = ChatDefaults(),
    chatViewModel: ChatViewModel = rememberChatState(koin, chatDefaults),
) {
    Column(
        Modifier
            .background(chatDefaults.colors.backgroundColor)
            .fillMaxHeight()
    ) {
        val scrollState = rememberLazyListState()
        val messages = chatViewModel.messages
        LazyColumn(
            state = scrollState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 8.dp),
        ) {
            item { Spacer(modifier = Modifier.padding(top = 16.dp)) }
            items(messages) { item ->
                when (item) {
                    is MessageType.User ->
                        BalloonUserMessage(
                            item.text,
                            chatDefaults,
                            item.isError,
                            onTryAgain = { chatViewModel.onTryAgain(it) }
                        )

                    is MessageType.Bot ->
                        BalloonBotMessage(item.text, chatDefaults)

                    is MessageType.Loading ->
                        BalloonBotTyping(chatDefaults)
                }
            }
        }
        SenderMessageSection(chatViewModel, chatDefaults)
    }
}

@Composable
private fun SenderMessageSection(
    chatViewModel: ChatViewModel,
    chatDefaults: ChatDefaults
) {
    Box {
        Divider(color = chatDefaults.colors.dividerColor)
        SendInputField(
            value = chatViewModel.message.value,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            chatDefaults = chatDefaults,
            isButtonVisible = chatViewModel.onButtonVisible.value,
            hint = chatDefaults.inputFieldHint,
            onTextChanged = { chatViewModel.onMessage(it) },
            onButtonClick = { chatViewModel.sendMessage() }
        )
    }
}

@Composable
private fun rememberChatState(
    koin: Koin,
    chatDefaults: ChatDefaults,
): ChatViewModel {
    val coroutine = rememberCoroutineScope()
    val chatViewModel = ChatViewModel(chatDefaults, coroutine, koin.get())
    return remember { chatViewModel }
}
