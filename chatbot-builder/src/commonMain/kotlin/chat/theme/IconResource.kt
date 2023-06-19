package chat.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

internal enum class IconResource(private val fileName: String) {
    BOT("ic_bot.xml");

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun painter(): Painter {
        return painterResource(this.fileName)
    }
}
