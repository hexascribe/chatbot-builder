package com.arstechna.chatbotbuilder.chat.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.arstechna.chatbotbuilder.chat.model.ChatDefaults

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun BalloonUserMessage(
    text: String,
    chatDefaults: ChatDefaults = ChatDefaults(),
    isError: Boolean = false,
    onTryAgain: (String) -> Unit = {}
) {
    var showError by remember { mutableStateOf(false) }
    showError = isError
    Column(
        Modifier
            .fillMaxWidth()
            .clickable(isError) { if (isError) onTryAgain(text) },
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(4.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                        )
                    )
                    .background(chatDefaults.colors.userBalloonColor)
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp),
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = chatDefaults.colors.userBalloonTextColor
            )
            AnimatedVisibility(visible = showError, enter = scaleIn(), exit = scaleOut()) {
                Icon(
                    Icons.Outlined.Warning,
                    null,
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
        AnimatedVisibility(visible = showError, enter = scaleIn(), exit = scaleOut()) {
            Text(
                chatDefaults.errorText,
                style = MaterialTheme.typography.labelSmall,
                color = chatDefaults.colors.errorTextColor,
            )
        }
    }
}

@Composable
internal fun BalloonBotMessage(
    text: String,
    chatDefaults: ChatDefaults = ChatDefaults()
) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(end = 64.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            chatDefaults.BotIcon()
            Text(
                text = text,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 16.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp,
                        )
                    )
                    .background(chatDefaults.colors.botBalloonColor)
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp),
                color = chatDefaults.colors.botBalloonTextColor,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Composable
internal fun BalloonBotTyping(
    chatDefaults: ChatDefaults = ChatDefaults()
) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(end = 64.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            chatDefaults.BotIcon()
            TypingTextLoading(
                chatDefaults = chatDefaults,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 16.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp,
                        )
                    )
                    .background(chatDefaults.colors.botBalloonColor)
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp),
            )
        }
    }
}
