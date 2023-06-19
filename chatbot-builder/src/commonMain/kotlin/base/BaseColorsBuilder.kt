package base

import androidx.compose.ui.graphics.Color
import chat.theme.color.Colors

abstract class BaseColorsBuilder<T, C: Colors> {
    internal abstract var colors: Colors

    abstract fun colorFactory(color: T): Color

    fun setBackgroundColor(color: T): BaseColorsBuilder<T, C> {
        colors.backgroundColor = colorFactory(color)
        return this
    }

    fun setUserBalloonColor(color: T): BaseColorsBuilder<T, C> {
        colors.userBalloonColor = colorFactory(color)
        return this
    }

    fun setUserBalloonTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.userBalloonTextColor = colorFactory(color)
        return this
    }

    fun setBotBalloonColor(color: T): BaseColorsBuilder<T, C> {
        colors.botBalloonColor = colorFactory(color)
        return this
    }

    fun setBotBalloonTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.botBalloonTextColor = colorFactory(color)
        return this
    }

    fun setInputFieldBackgroundColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldBackgroundColor = colorFactory(color)
        return this
    }

    fun setInputFieldTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldTextColor = colorFactory(color)
        return this
    }

    fun setInputFieldHintColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldHintColor = colorFactory(color)
        return this
    }

    fun setInputFieldFocusedIndicatorColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldFocusedIndicatorColor = colorFactory(color)
        return this
    }

    fun setInputFieldUnfocusedIndicatorColor(color: T): BaseColorsBuilder<T, C> {
        colors.inputFieldUnfocusedIndicatorColor = colorFactory(color)
        return this
    }

    fun setSendButtonColor(color: T): BaseColorsBuilder<T, C> {
        colors.sendButtonColor = colorFactory(color)
        return this
    }

    fun setDividerColor(color: T): BaseColorsBuilder<T, C> {
        colors.dividerColor = colorFactory(color)
        return this
    }

    fun setLoadingTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.loadingTextColor = colorFactory(color)
        return this
    }

    fun setErrorTextColor(color: T): BaseColorsBuilder<T, C> {
        colors.errorTextColor = colorFactory(color)
        return this
    }
}
