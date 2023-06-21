package com.arstechna.chatbotbuilder

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import com.arstechna.chatbotbuilder.base.BaseBuilder
import com.arstechna.chatbotbuilder.base.BaseColorsBuilder
import com.arstechna.chatbotbuilder.impl.ChatBotImpl
import platform.UIKit.UIColor
import platform.UIKit.UIImage
import platform.UIKit.UIViewController
import com.arstechna.chatbotbuilder.chat.theme.color.Colors
import com.arstechna.chatbotbuilder.chat.theme.color.DarkColors
import com.arstechna.chatbotbuilder.chat.theme.color.DefaultColors
import com.arstechna.chatbotbuilder.utils.toColor
import com.arstechna.chatbotbuilder.utils.toHexString
import com.arstechna.chatbotbuilder.utils.toSkiaImage

abstract class ChatBot {

    abstract fun getViewController(): UIViewController

    class Builder(private val apiKey: String) : BaseBuilder<UIColor, UIImage, ChatBot>() {
        override fun imageFactory(image: UIImage): ImageBitmap? {
            return image.toSkiaImage()?.toComposeImageBitmap()
        }

        override fun build(): ChatBot {
            return ChatBotImpl(apiKey, defaults)
        }
    }

    class DarkColorsBuilder : BaseColorsBuilder<UIColor, DarkColors>() {
        override var colors: Colors = DarkColors()
        override fun colorFactory(color: UIColor): Color {
            return color.toHexString().toColor
        }
    }

    class DefaultColorsBuilder : BaseColorsBuilder<UIColor, DefaultColors>() {
        override var colors: Colors = DefaultColors()
        override fun colorFactory(color: UIColor): Color {
            return color.toHexString().toColor
        }
    }
}
