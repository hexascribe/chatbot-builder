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

/**
 * The ChatBot Builder is a SDK that allows seamless customization of the Chat UI to match the look
 * and feel of your application, while also providing the ability to define specific instructions
 * for the bot's behavior using the [OpenAI API](https://platform.openai.com/docs/api-reference).
 */
public abstract class ChatBot {

    /**
     * Returns the view controller for the ChatBot.
     * @return The view controller representing the Chat UI.
     */
    public abstract fun getViewController(): UIViewController

    /**
     * Builder class for creating a ChatBot instance.
     * @param apiKey The API key obtained from the OpenAI API for authentication.
     * See [this](https://platform.openai.com/docs/api-reference/authentication) for more details on how
     * to get the api key.
     */
    public class Builder(private val apiKey: String) : BaseBuilder<UIColor, UIImage, ChatBot>() {
        override fun imageFactory(image: UIImage): ImageBitmap? {
            return image.toSkiaImage()?.toComposeImageBitmap()
        }

        override fun build(): ChatBot {
            return ChatBotImpl(apiKey, defaults)
        }
    }

    /**
     * Builder class for defining dark color schemes for the ChatBot UI.
     */
    public class DarkColorsBuilder : BaseColorsBuilder<UIColor, DarkColors>() {
        override var colors: Colors = DarkColors()
        override fun colorFactory(color: UIColor): Color {
            return color.toHexString().toColor
        }
    }

    /**
     * Builder class for defining default color schemes for the ChatBot UI.
     */
    public class DefaultColorsBuilder : BaseColorsBuilder<UIColor, DefaultColors>() {
        override var colors: Colors = DefaultColors()
        override fun colorFactory(color: UIColor): Color {
            return color.toHexString().toColor
        }
    }
}
