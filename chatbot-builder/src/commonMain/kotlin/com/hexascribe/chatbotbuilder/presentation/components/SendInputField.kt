package com.hexascribe.chatbotbuilder.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.hexascribe.chatbotbuilder.presentation.model.ChatDefaults

@Composable
internal fun SendInputField(
    value: String,
    modifier: Modifier = Modifier,
    chatDefaults: ChatDefaults = ChatDefaults(),
    hint: String = "",
    isButtonVisible: Boolean = true,
    readOnly: Boolean = false,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onButtonClick: () -> Unit = {},
    onTextChanged: (String) -> Unit = {},
) {
    var hasFocus by remember { mutableStateOf(false) }
    val focusColor = chatDefaults.colors.inputFieldFocusedIndicatorColor
    val unFocusColor = chatDefaults.colors.inputFieldUnfocusedIndicatorColor
    var showSendButton by remember { mutableStateOf(isButtonVisible) }
    showSendButton = isButtonVisible
    OutlinedTextField(
        value = value,
        onValueChange = { onTextChanged(it) },
        modifier = modifier
            .border(
                width = chatDefaults.inputFieldBorderWidth.dp,
                color = if (hasFocus) focusColor else unFocusColor,
                shape = RoundedCornerShape(chatDefaults.inputFieldCornerRadius.dp),
            )
            .onFocusChanged { focusState -> hasFocus = focusState.hasFocus }
            .fillMaxWidth(),
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        maxLines = maxLines,
        shape = RoundedCornerShape(chatDefaults.inputFieldCornerRadius.dp),
        placeholder = {
            Text(
                hint,
                color = chatDefaults.colors.inputFieldHintColor,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = chatDefaults.colors.inputFieldTextColor,
            focusedContainerColor = chatDefaults.colors.inputFieldBackgroundColor,
            unfocusedContainerColor = chatDefaults.colors.inputFieldBackgroundColor,
            focusedIndicatorColor = Color.Unspecified,
            unfocusedIndicatorColor = Color.Unspecified,
            disabledIndicatorColor = Color.Unspecified,
            cursorColor = chatDefaults.colors.cursorColor,
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            AnimatedVisibility(
                showSendButton,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                IconButton(
                    onClick = onButtonClick,
                    enabled = isButtonVisible
                ) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        tint = chatDefaults.colors.sendButtonColor,
                        contentDescription = null
                    )
                }
            }
        }
    )
}
