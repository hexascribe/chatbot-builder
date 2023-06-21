package com.hexascribe.chatbotbuilder

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import com.hexascribe.chatbotbuilder.base.BaseBuilder
import com.hexascribe.chatbotbuilder.base.BaseColorsBuilder
import com.hexascribe.chatbotbuilder.chat.theme.color.Colors
import com.hexascribe.chatbotbuilder.chat.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.chat.theme.color.DefaultColors
import com.hexascribe.chatbotbuilder.impl.ChatBotImpl

public abstract class ChatBot {

    @Composable
    public abstract fun ChatScreen()

    public class Builder(private val apiKey: String) : BaseBuilder<Color, ImageBitmap, ChatBot>() {
        override fun imageFactory(image: ImageBitmap): ImageBitmap {
            return image
        }

        override fun build(): ChatBot {
            return ChatBotImpl(apiKey, defaults)
        }
    }

    public class DarkColorsBuilder : BaseColorsBuilder<Color, DarkColors>() {
        override var colors: Colors = DarkColors()
        override fun colorFactory(color: Color): Color {
            return color
        }
    }

    public class DefaultColorsBuilder : BaseColorsBuilder<Color, DefaultColors>() {
        override var colors: Colors = DefaultColors()
        override fun colorFactory(color: Color): Color {
            return color
        }
    }
}
