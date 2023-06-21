package com.hexascribe.chatbotbuilder.base

import androidx.compose.ui.graphics.ImageBitmap
import com.hexascribe.chatbotbuilder.chat.model.ChatDefaults
import com.hexascribe.chatbotbuilder.chat.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.chat.theme.color.DefaultColors
import co.yml.ychat.domain.model.ChatMessage

abstract class BaseBuilder<COLOR, IMAGE : Any, VIEW : Any> {

    internal val defaults: ChatDefaults = ChatDefaults()

    fun setDarkColorsBuilder(
        darkColorsBuilder: BaseColorsBuilder<COLOR, DarkColors>
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.darkColors = darkColorsBuilder.colors as DarkColors
        return this
    }

    fun setDefaultColorsBuilder(
        defaultColorsBuilder: BaseColorsBuilder<COLOR, DefaultColors>
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.defaultColors = defaultColorsBuilder.colors as DefaultColors
        return this
    }

    fun setDarkMode(isEnabled: Boolean): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.isDarkModeEnabled = isEnabled
        return this
    }

    fun setBotIcon(image: IMAGE): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.botIconBitmap = imageFactory(image)
        return this
    }

    fun addMessage(role: RoleEnum, content: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.messages.add(ChatMessage(role.name.lowercase(), content))
        return this
    }

    fun addPreSeededMessage(role: RoleEnum, content: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.preSeededMessages.add(ChatMessage(role.name.lowercase(), content))
        return this
    }

    fun setInputFieldCornerRadius(cornerRadius: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldCornerRadius = cornerRadius
        return this
    }

    fun setInputFieldBorderWidth(borderWidth: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldBorderWidth = borderWidth
        return this
    }

    fun setInputFieldHint(hint: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldHint = hint
        return this
    }

    fun setMaxTokens(tokens: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.maxTokens = tokens
        return this
    }

    fun setErrorText(text: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.errorText = text
        return this
    }

    internal abstract fun imageFactory(image: IMAGE): ImageBitmap?

    abstract fun build(): VIEW
}
