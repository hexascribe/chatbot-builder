package com.hexascribe.chatbotbuilder.base

import androidx.compose.ui.graphics.ImageBitmap
import com.hexascribe.chatbotbuilder.chat.model.ChatDefaults
import com.hexascribe.chatbotbuilder.chat.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.chat.theme.color.DefaultColors
import co.yml.ychat.domain.model.ChatMessage

public abstract class BaseBuilder<COLOR, IMAGE : Any, VIEW : Any> {

    internal val defaults: ChatDefaults = ChatDefaults()

    public fun setDarkColorsBuilder(
        darkColorsBuilder: BaseColorsBuilder<COLOR, DarkColors>
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.darkColors = darkColorsBuilder.colors as DarkColors
        return this
    }

    public fun setDefaultColorsBuilder(
        defaultColorsBuilder: BaseColorsBuilder<COLOR, DefaultColors>
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.defaultColors = defaultColorsBuilder.colors as DefaultColors
        return this
    }

    public fun setDarkMode(isEnabled: Boolean): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.isDarkModeEnabled = isEnabled
        return this
    }

    public fun setBotIcon(image: IMAGE): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.botIconBitmap = imageFactory(image)
        return this
    }

    public fun addMessage(role: RoleEnum, content: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.messages.add(ChatMessage(role.name.lowercase(), content))
        return this
    }

    public fun addPreSeededMessage(role: RoleEnum, content: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.preSeededMessages.add(ChatMessage(role.name.lowercase(), content))
        return this
    }

    public fun setInputFieldCornerRadius(cornerRadius: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldCornerRadius = cornerRadius
        return this
    }

    public fun setInputFieldBorderWidth(borderWidth: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldBorderWidth = borderWidth
        return this
    }

    public fun setInputFieldHint(hint: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldHint = hint
        return this
    }

    public fun setMaxTokens(tokens: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.maxTokens = tokens
        return this
    }

    public fun setErrorText(text: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.errorText = text
        return this
    }

    internal abstract fun imageFactory(image: IMAGE): ImageBitmap?

    public abstract fun build(): VIEW
}
