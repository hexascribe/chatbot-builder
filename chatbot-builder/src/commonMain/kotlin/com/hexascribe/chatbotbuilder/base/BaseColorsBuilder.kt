package com.hexascribe.chatbotbuilder.base

import androidx.compose.ui.graphics.Color
import com.hexascribe.chatbotbuilder.chat.theme.color.Colors

public abstract class BaseColorsBuilder<T, C: Colors> {
    internal abstract var colors: Colors

    public abstract fun colorFactory(color: T): Color

    public fun setBackgroundColor(color: T): BaseColorsBuilder<T, C> {
        colors.backgroundColor = colorFactory(color)
        return this
    }

    public fun setUserBalloonColor(color: T): BaseColorsBuilder<T, C> {
        colors.userBalloonColor = colorFactory(color)
        return this
    }

    public fun setUserBalloonTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.userBalloonTextColor = colorFactory(color)
        return this
    }

    public fun setBotBalloonColor(color: T): BaseColorsBuilder<T, C> {
        colors.botBalloonColor = colorFactory(color)
        return this
    }

    public fun setBotBalloonTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.botBalloonTextColor = colorFactory(color)
        return this
    }

    public fun setInputFieldBackgroundColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldBackgroundColor = colorFactory(color)
        return this
    }

    public fun setInputFieldTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldTextColor = colorFactory(color)
        return this
    }

    public fun setInputFieldHintColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldHintColor = colorFactory(color)
        return this
    }

    public fun setInputFieldFocusedIndicatorColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldFocusedIndicatorColor = colorFactory(color)
        return this
    }

    public fun setInputFieldUnfocusedIndicatorColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldUnfocusedIndicatorColor = colorFactory(color)
        return this
    }

    public fun setSendButtonColor(color: T): BaseColorsBuilder<T, C> {
        colors.sendButtonColor = colorFactory(color)
        return this
    }

    public fun setDividerColor(color: T): BaseColorsBuilder<T, C> {
        colors.dividerColor = colorFactory(color)
        return this
    }

    public fun setLoadingTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.loadingTextColor = colorFactory(color)
        return this
    }

    public fun setErrorTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.errorTextColor = colorFactory(color)
        return this
    }
}
