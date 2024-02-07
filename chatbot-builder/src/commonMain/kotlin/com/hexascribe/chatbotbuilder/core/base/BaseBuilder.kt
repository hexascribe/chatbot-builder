package com.hexascribe.chatbotbuilder.core.base

import androidx.compose.ui.graphics.ImageBitmap
import com.hexascribe.chatbotbuilder.core.enums.RoleEnum
import com.hexascribe.chatbotbuilder.domain.model.ChatMessageModel
import com.hexascribe.chatbotbuilder.presentation.model.ChatDefaults
import com.hexascribe.chatbotbuilder.presentation.theme.color.DarkColors
import com.hexascribe.chatbotbuilder.presentation.theme.color.DefaultColors

public abstract class BaseBuilder<COLOR, IMAGE : Any, VIEW : Any> {

    internal val defaults: ChatDefaults = ChatDefaults()

    /**
     * Sets the DarkColorsBuilder to configure dark color schemes for the Chat UI.
     * @param darkColorsBuilder The DarkColorsBuilder instance to set.
     * @return The instance of the BaseBuilder with the updated DarkColorsBuilder.
     */
    public fun setDarkColorsBuilder(
        darkColorsBuilder: BaseColorsBuilder<COLOR, DarkColors>
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.darkColors = darkColorsBuilder.colors as DarkColors
        return this
    }

    /**
     * Sets the DefaultColorsBuilder to configure default color schemes for the Chat UI.
     * @param defaultColorsBuilder The DefaultColorsBuilder instance to set.
     * @return The instance of the BaseBuilder with the updated DefaultColorsBuilder.
     */
    public fun setDefaultColorsBuilder(
        defaultColorsBuilder: BaseColorsBuilder<COLOR, DefaultColors>
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.defaultColors = defaultColorsBuilder.colors as DefaultColors
        return this
    }

    /**
     * Enables or disables the dark mode for the Chat UI.
     * @param isEnabled A boolean value indicating whether dark mode should be enabled or not.
     * @return The instance of the BaseBuilder with the updated dark mode setting.
     */
    public fun setDarkMode(isEnabled: Boolean): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.isDarkModeEnabled = isEnabled
        return this
    }

    /***
     * Sets the bot icon image for the Chat UI.
     * @param image The image to set as the bot icon.
     * @return The instance of the BaseBuilder with the updated bot icon image.
     */
    public fun setBotIcon(image: IMAGE): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.botIconBitmap = imageFactory(image)
        return this
    }

    /**
     * Add a new message that will be displayed in the chat. The message can be displayed as either
     * [RoleEnum.USER] or [RoleEnum.ASSISTANT]. Messages with the role [RoleEnum.SYSTEM]
     * will be ignored.
     * @param role The role of the message sender (either [RoleEnum.USER] or [RoleEnum.ASSISTANT]).
     * @param content The content of the message.
     * @return The instance of the BaseBuilder with the added message.
     */
    public fun addMessage(role: RoleEnum, content: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.messages.add(ChatMessageModel(role, content))
        return this
    }

    /**
     * This method can be used to provide memory to the model. It allows you to set up prompts
     * and engineer the behavior of the bot. You can pass instructions from [RoleEnum.SYSTEM]
     * or provide chat message examples from [RoleEnum.USER] and [RoleEnum.ASSISTANT].
     * @param role The role of the message sender ([RoleEnum.USER], [RoleEnum.ASSISTANT], [RoleEnum.SYSTEM]).
     * @param content The content of the pre-seeded message.
     * @return The instance of the BaseBuilder with the added pre-seeded message.
     */
    public fun addPreSeededMessage(
        role: RoleEnum,
        content: String
    ): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.preSeededMessages.add(ChatMessageModel(role, content))
        return this
    }

    /**
     * Sets the corner radius for the input field in the Chat UI.
     * @param cornerRadius The corner radius value to set.
     * @return The instance of the BaseBuilder with the updated input field corner radius.
     */
    public fun setInputFieldCornerRadius(cornerRadius: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldCornerRadius = cornerRadius
        return this
    }

    /**
     * Sets the border width for the input field in the Chat UI.
     * @param borderWidth The border width value to set.
     * @return The instance of the BaseBuilder with the updated input field border width.
     */
    public fun setInputFieldBorderWidth(borderWidth: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldBorderWidth = borderWidth
        return this
    }

    /**
     * Sets the hint text for the input field in the Chat UI.
     * @param hint The hint text to set.
     * @return The instance of the BaseBuilder with the updated input field hint text.
     */
    public fun setInputFieldHint(hint: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.inputFieldHint = hint
        return this
    }

    /**
     * Sets the maximum number of tokens for the Chat UI.
     * @param tokens The maximum number of tokens to set.
     * @return The instance of the BaseBuilder with the updated maximum tokens setting.
     */
    public fun setMaxTokens(tokens: Int): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.maxTokens = tokens
        return this
    }

    /**
     * Sets the error text for the Chat UI.
     * @param text The error text to set.
     * @return The instance of the BaseBuilder with the updated error text.
     */
    public fun setErrorText(text: String): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.errorText = text
        return this
    }

    /**
     * Sets the log error flag.
     * @param isEnabled Specifies whether logging of errors should be enabled or not.
     * @return The instance of the BaseBuilder with the updated log error flag.
     */
    public fun setLogError(isEnabled: Boolean): BaseBuilder<COLOR, IMAGE, VIEW> {
        defaults.isLogErrorEnabled = isEnabled
        return this
    }

    /**
     * Creates an ImageBitmap object from the provided UIImage.
     * @param image The UIImage to be converted.
     * @return The corresponding ImageBitmap, or null if conversion fails.
     */
    internal abstract fun imageFactory(image: IMAGE): ImageBitmap?

    /**
     * Builds and returns a ChatBot instance with the specified OpenAI API key and
     * default configurations.
     * @return The created ChatBot instance.
     */
    public abstract fun build(): VIEW
}
