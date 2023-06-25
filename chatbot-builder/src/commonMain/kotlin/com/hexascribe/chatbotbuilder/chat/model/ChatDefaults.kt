package com.hexascribe.chatbotbuilder.chat.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.hexascribe.chatbotbuilder.chat.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.chat.theme.color.DefaultColors
import com.hexascribe.chatbotbuilder.chat.theme.icons.IconBot
import co.yml.ychat.domain.model.ChatMessage

internal data class ChatDefaults(
    var isDarkModeEnabled: Boolean = false,
    var darkColors: DarkColors = DarkColors(),
    var defaultColors: DefaultColors = DefaultColors(),
    var preSeededMessages: ArrayList<ChatMessage> = ArrayList(),
    var messages: ArrayList<ChatMessage> = ArrayList(),
    var errorText: String = "Not Delivered. Tap to try again.",
    var loadingText: String = "Typing",
    var inputFieldBorderWidth: Int = 1,
    var inputFieldCornerRadius: Int = 8,
    var inputFieldHint: String = "Send a message",
    var botIconBitmap: ImageBitmap? = null,
    var maxTokens: Int = 1024,
    var isLogErrorEnabled: Boolean = false,
) {

    val colors by lazy {
        if (isDarkModeEnabled) darkColors else defaultColors
    }

    @Composable
    fun BotIcon() {
        if (botIconBitmap != null) {
            Image(botIconBitmap!!, null)
        } else {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF19C37D))
                    .padding(4.dp),
                tint = Color.White,
                imageVector = Icons.IconBot(),
                contentDescription = null
            )
        }
    }
}
