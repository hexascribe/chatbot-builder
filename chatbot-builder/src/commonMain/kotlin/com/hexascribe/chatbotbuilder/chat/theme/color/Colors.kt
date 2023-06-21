package com.hexascribe.chatbotbuilder.chat.theme.color

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
open class Colors(
    backgroundColor: Color,
    userBalloonColor: Color,
    userBalloonTextColor: Color,
    botBalloonColor: Color,
    botBalloonTextColor: Color,
    inputFieldBackgroundColor: Color,
    inputFieldTextColor: Color,
    inputFieldHintColor: Color,
    inputFieldFocusedIndicatorColor: Color,
    inputFieldUnfocusedIndicatorColor: Color,
    cursorColor: Color,
    sendButtonColor: Color,
    dividerColor: Color,
    loadingTextColor: Color,
    errorTextColor: Color,
) {
    var backgroundColor by mutableStateOf(backgroundColor)

    var userBalloonColor by mutableStateOf(userBalloonColor)

    var userBalloonTextColor by mutableStateOf(userBalloonTextColor)

    var botBalloonColor by mutableStateOf(botBalloonColor)

    var botBalloonTextColor by mutableStateOf(botBalloonTextColor)

    var inputFieldBackgroundColor by mutableStateOf(inputFieldBackgroundColor)

    var inputFieldTextColor by mutableStateOf(inputFieldTextColor)

    var inputFieldHintColor by mutableStateOf(inputFieldHintColor)

    var inputFieldFocusedIndicatorColor by mutableStateOf(inputFieldFocusedIndicatorColor)

    var inputFieldUnfocusedIndicatorColor by mutableStateOf(inputFieldUnfocusedIndicatorColor)

    var cursorColor by mutableStateOf(cursorColor)

    var sendButtonColor by mutableStateOf(sendButtonColor)

    var dividerColor by mutableStateOf(dividerColor)

    var loadingTextColor by mutableStateOf(loadingTextColor)

    var errorTextColor by mutableStateOf(errorTextColor)
}

class DarkColors(
    backgroundColor: Color = Color.Black,
    userBalloonColor: Color = Color.White,
    userBalloonTextColor: Color = Color.Black,
    botBalloonColor: Color = Color.White.copy(alpha = 0.12F),
    botBalloonTextColor: Color = Color.White,
    inputFieldBackgroundColor: Color = Color.White.copy(alpha = 0.06F),
    inputFieldTextColor: Color = Color.White,
    inputFieldHintColor: Color = Color.White.copy(alpha = 0.4F),
    inputFieldFocusedIndicatorColor: Color = Color.White,
    inputFieldUnfocusedIndicatorColor: Color = Color.Unspecified,
    cursorColor: Color = Color.White,
    sendButtonColor: Color = Color.White,
    dividerColor: Color = Color.White.copy(alpha = 0.12F),
    loadingTextColor: Color = Color.White.copy(alpha = 0.40F),
    errorTextColor: Color = Color.White.copy(alpha = 0.60F),
) : Colors(
    backgroundColor = backgroundColor,
    userBalloonColor = userBalloonColor,
    userBalloonTextColor = userBalloonTextColor,
    botBalloonColor = botBalloonColor,
    botBalloonTextColor = botBalloonTextColor,
    inputFieldBackgroundColor = inputFieldBackgroundColor,
    inputFieldTextColor = inputFieldTextColor,
    inputFieldHintColor = inputFieldHintColor,
    inputFieldFocusedIndicatorColor = inputFieldFocusedIndicatorColor,
    inputFieldUnfocusedIndicatorColor = inputFieldUnfocusedIndicatorColor,
    cursorColor = cursorColor,
    sendButtonColor = sendButtonColor,
    dividerColor = dividerColor,
    loadingTextColor = loadingTextColor,
    errorTextColor = errorTextColor,
)

class DefaultColors(
    backgroundColor: Color = Color.White,
    userBalloonColor: Color = Color.Black,
    userBalloonTextColor: Color = Color.White,
    botBalloonColor: Color = Color.Black.copy(alpha = 0.12F),
    botBalloonTextColor: Color = Color.Black,
    inputFieldBackgroundColor: Color = Color.Black.copy(alpha = 0.06F),
    inputFieldTextColor: Color = Color.Black,
    inputFieldHintColor: Color = Color.Black.copy(alpha = 0.3F),
    inputFieldFocusedIndicatorColor: Color = Color.Black,
    inputFieldUnfocusedIndicatorColor: Color = Color.Unspecified,
    cursorColor: Color = Color.Black,
    sendButtonColor: Color = Color.Black,
    dividerColor: Color = Color.Black.copy(alpha = 0.12F),
    loadingTextColor: Color = Color.Black.copy(alpha = 0.30F),
    errorTextColor: Color = Color.Black.copy(alpha = 0.60F),
) : Colors(
    backgroundColor = backgroundColor,
    userBalloonColor = userBalloonColor,
    userBalloonTextColor = userBalloonTextColor,
    botBalloonColor = botBalloonColor,
    botBalloonTextColor = botBalloonTextColor,
    inputFieldBackgroundColor = inputFieldBackgroundColor,
    inputFieldTextColor = inputFieldTextColor,
    inputFieldHintColor = inputFieldHintColor,
    inputFieldFocusedIndicatorColor = inputFieldFocusedIndicatorColor,
    inputFieldUnfocusedIndicatorColor = inputFieldUnfocusedIndicatorColor,
    cursorColor = cursorColor,
    sendButtonColor = sendButtonColor,
    dividerColor = dividerColor,
    loadingTextColor = loadingTextColor,
    errorTextColor = errorTextColor,
)
