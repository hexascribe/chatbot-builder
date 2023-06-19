import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import base.BaseBuilder
import base.BaseColorsBuilder
import chat.theme.Colors
import chat.theme.DarkColors
import chat.theme.DefaultColors
import impl.ChatBotImpl

abstract class ChatBot {

    @Composable
    abstract fun ChatScreen()

    class Builder(private val apiKey: String) : BaseBuilder<Color, ImageBitmap, ChatBot>() {
        override fun imageFactory(image: ImageBitmap): ImageBitmap {
            return image
        }

        override fun build(): ChatBot {
            return ChatBotImpl(apiKey, defaults)
        }
    }

    class DarkColorsBuilder : BaseColorsBuilder<Color, DarkColors>() {
        override var colors: Colors = DarkColors()
        override fun colorFactory(color: Color): Color {
            return color
        }
    }

    class DefaultColorsBuilder : BaseColorsBuilder<Color, DefaultColors>() {
        override var colors: Colors = DefaultColors()
        override fun colorFactory(color: Color): Color {
            return color
        }
    }
}
