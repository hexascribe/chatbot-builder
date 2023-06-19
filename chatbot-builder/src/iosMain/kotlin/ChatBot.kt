import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import base.BaseBuilder
import base.BaseColorsBuilder
import impl.ChatBotImpl
import platform.UIKit.UIColor
import platform.UIKit.UIImage
import platform.UIKit.UIViewController
import chat.theme.Colors
import chat.theme.DarkColors
import chat.theme.DefaultColors
import utils.toColor
import utils.toHexString
import utils.toSkiaImage

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
