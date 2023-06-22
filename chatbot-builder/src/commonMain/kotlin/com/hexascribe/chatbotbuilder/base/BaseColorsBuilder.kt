package com.hexascribe.chatbotbuilder.base

import androidx.compose.ui.graphics.Color
import com.hexascribe.chatbotbuilder.chat.theme.color.Colors

public abstract class BaseColorsBuilder<T, C : Colors> {
    internal abstract var colors: Colors

    /**
     * Converts a UIColor to a Color object.
     * @param color The UIColor to be converted.
     * @return The corresponding Color object.
     */
    public abstract fun colorFactory(color: T): Color

    /**
     * Sets the background color for the Chat UI.
     * @param color The color to set as the background color.
     * @return The instance of the BaseColorsBuilder with the updated background color.
     */
    public fun setBackgroundColor(color: T): BaseColorsBuilder<T, C> {
        colors.backgroundColor = colorFactory(color)
        return this
    }

    /**
     * Sets the balloon color for the user's messages.
     * @param color The color to set as the user balloon color.
     * @return The instance of the BaseColorsBuilder with the updated user balloon color.
     */
    public fun setUserBalloonColor(color: T): BaseColorsBuilder<T, C> {
        colors.userBalloonColor = colorFactory(color)
        return this
    }

    /**
     * Sets the text color for the user's messages in the Chat UI.
     * @param color The color to set as the user balloon text color.
     * @return The instance of the BaseColorsBuilder with the updated user balloon text color.
     */
    public fun setUserBalloonTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.userBalloonTextColor = colorFactory(color)
        return this
    }

    /**
     * Sets the balloon color for the bot's messages.
     * @param color The color to set as the bot balloon color.
     * @return The instance of the BaseColorsBuilder with the updated bot balloon color.
     */
    public fun setBotBalloonColor(color: T): BaseColorsBuilder<T, C> {
        colors.botBalloonColor = colorFactory(color)
        return this
    }

    /**
     * Sets the text color for the bot's messages in the Chat UI.
     * @param color The color to set as the bot balloon text color.
     * @return The instance of the BaseColorsBuilder with the updated bot balloon text color.
     */
    public fun setBotBalloonTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.botBalloonTextColor = colorFactory(color)
        return this
    }

    /**
     * Sets the background color for the input field in the Chat UI.
     * @param color The color to set as the input field background color.
     * @return The instance of the BaseColorsBuilder with the updated input field background color.
     */
    public fun setInputFieldBackgroundColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldBackgroundColor = colorFactory(color)
        return this
    }

    /**
     * Sets the text color for the input field in the Chat UI.
     * @param color The color to set as the input field text color.
     * @return The instance of the BaseColorsBuilder with the updated input field text color.
     */
    public fun setInputFieldTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldTextColor = colorFactory(color)
        return this
    }

    /**
     * Sets the hint color for the input field in the Chat UI.
     * @param color The color to set as the input field hint color.
     * @return The instance of the BaseColorsBuilder with the updated input field hint color.
     */
    public fun setInputFieldHintColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldHintColor = colorFactory(color)
        return this
    }

    /**
     * Sets the color for the focused state indicator of the input field in the Chat UI.
     * @param color The color to set as the input field focused indicator color.
     * @return The instance of the BaseColorsBuilder with the updated input field focused indicator color.
     */
    public fun setInputFieldFocusedIndicatorColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldFocusedIndicatorColor = colorFactory(color)
        return this
    }

    /**
     * Sets the color for the unfocused state indicator of the input field in the Chat UI.
     * @param color The color to set as the input field unfocused indicator color.
     * @return The instance of the BaseColorsBuilder with the updated input field unfocused indicator color.
     */
    public fun setInputFieldUnfocusedIndicatorColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldUnfocusedIndicatorColor = colorFactory(color)
        return this
    }

    /**
     * Sets the color for the send button in the Chat UI.
     * @param color The color to set as the send button color.
     * @return The instance of the BaseColorsBuilder with the updated send button color.
     */
    public fun setSendButtonColor(color: T): BaseColorsBuilder<T, C> {
        colors.sendButtonColor = colorFactory(color)
        return this
    }

    /**
     * Sets the color for the divider between messages in the Chat UI.
     * @param color The color to set as the divider color.
     * @return The instance of the BaseColorsBuilder with the updated divider color.
     */
    public fun setDividerColor(color: T): BaseColorsBuilder<T, C> {
        colors.dividerColor = colorFactory(color)
        return this
    }

    /**
     * Sets the text color for the loading indicator in the Chat UI.
     * @param color The color to set as the loading indicator text color.
     * @return The instance of the BaseColorsBuilder with the updated loading indicator text color.
     */
    public fun setLoadingTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.loadingTextColor = colorFactory(color)
        return this
    }

    /**
     * Sets the text color for error messages in the Chat UI.
     * @param color The color to set as the error message text color.
     * @return The instance of the BaseColorsBuilder with the updated error message text color.
     */
    public fun setErrorTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.errorTextColor = colorFactory(color)
        return this
    }
}
