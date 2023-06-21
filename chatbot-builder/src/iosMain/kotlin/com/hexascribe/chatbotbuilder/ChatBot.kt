package com.hexascribe.chatbotbuilder

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import com.hexascribe.chatbotbuilder.base.BaseBuilder
import com.hexascribe.chatbotbuilder.base.BaseColorsBuilder
import com.hexascribe.chatbotbuilder.impl.ChatBotImpl
import platform.UIKit.UIColor
import platform.UIKit.UIImage
import platform.UIKit.UIViewController
import com.hexascribe.chatbotbuilder.chat.theme.color.Colors
import com.hexascribe.chatbotbuilder.chat.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.chat.theme.color.DefaultColors
import com.hexascribe.chatbotbuilder.utils.toColor
import com.hexascribe.chatbotbuilder.utils.toHexString
import com.hexascribe.chatbotbuilder.utils.toSkiaImage

public abstract class ChatBot {

    public abstract fun getViewController(): UIViewController

    public class Builder(private val apiKey: String) : BaseBuilder<UIColor, UIImage, ChatBot>() {
        override fun imageFactory(image: UIImage): ImageBitmap? {
            return image.toSkiaImage()?.toComposeImageBitmap()
        }

        override fun build(): ChatBot {
            return ChatBotImpl(apiKey, defaults)
        }
    }

    public class DarkColorsBuilder : BaseColorsBuilder<UIColor, DarkColors>() {
        override var colors: Colors = DarkColors()
        override fun colorFactory(color: UIColor): Color {
            return color.toHexString().toColor
        }
    }

    public class DefaultColorsBuilder : BaseColorsBuilder<UIColor, DefaultColors>() {
        override var colors: Colors = DefaultColors()
        override fun colorFactory(color: UIColor): Color {
            return color.toHexString().toColor
        }
    }
}
