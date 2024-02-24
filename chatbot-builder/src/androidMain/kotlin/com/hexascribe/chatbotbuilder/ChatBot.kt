package com.hexascribe.chatbotbuilder

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import com.hexascribe.chatbotbuilder.core.base.BaseBuilder
import com.hexascribe.chatbotbuilder.core.base.BaseColorsBuilder
import com.hexascribe.chatbotbuilder.impl.ChatBotImpl
import com.hexascribe.chatbotbuilder.presentation.theme.color.Colors
import com.hexascribe.chatbotbuilder.presentation.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.presentation.theme.color.DefaultColors

/**
 * The ChatBot Builder is a SDK that allows seamless customization of the Chat UI to match the look
 * and feel of your application, while also providing the ability to define specific instructions
 * for the bot's behavior using the [OpenAI API](https://platform.openai.com/docs/api-reference).
 */
public abstract class ChatBot {

    /**
     * Jetpack Compose Screen for the Chat.
     */
    @Composable
    public abstract fun ComposeScreen()

    /**
     * Builder class for creating a ChatBot instance.
     * @param apiKey The API key obtained from the OpenAI API for authentication.
     * See [this](https://platform.openai.com/docs/api-reference/authentication) for more details on how
     * to get the api key.
     */
    public class Builder(private val apiKey: String) : BaseBuilder<Color, ImageBitmap, ChatBot>() {

        public fun setBotIcon(
            context: Context,
            @DrawableRes resourceId: Int
        ): BaseBuilder<Color, ImageBitmap, ChatBot> {
            val imageBitmap = AppCompatResources.getDrawable(context, resourceId)
                ?.toBitmap()
                ?.asImageBitmap()
            defaults.botIconBitmap = imageBitmap
            return this
        }

        override fun imageFactory(image: ImageBitmap): ImageBitmap {
            return image
        }

        override fun build(): ChatBot {
            return ChatBotImpl(apiKey, defaults)
        }
    }

    /**
     * Builder class for defining dark color schemes for the ChatBot UI.
     */
    public class DarkColorsBuilder : BaseColorsBuilder<Color, DarkColors>() {
        override var colors: Colors = DarkColors()
        override fun colorFactory(color: Color): Color {
            return color
        }
    }

    /**
     * Builder class for defining default color schemes for the ChatBot UI.
     */
    public class DefaultColorsBuilder : BaseColorsBuilder<Color, DefaultColors>() {
        override var colors: Colors = DefaultColors()
        override fun colorFactory(color: Color): Color {
            return color
        }
    }
}
