package com.hexascribe.chatbotbuilder.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hexascribe.chatbotbuilder.presentation.model.ChatDefaults
import kotlinx.coroutines.delay

private const val TYPING_INTERVAL = 250L

@Composable
internal fun TypingTextLoading(
    modifier: Modifier = Modifier,
    chatDefaults: ChatDefaults = ChatDefaults(),
) {
    val typingProgressOne = "${chatDefaults.loadingText}."
    val typingProgressTwo = "${chatDefaults.loadingText}.."
    val typingProgressThree = "${chatDefaults.loadingText}..."
    var textToDisplay by remember {
        mutableStateOf(typingProgressOne)
    }
    Text(
        modifier = modifier,
        text = textToDisplay,
        color = chatDefaults.colors.loadingTextColor,
        style = MaterialTheme.typography.bodyMedium,
    )
    LaunchedEffect(Unit) {
        while (true) {
            textToDisplay = when (textToDisplay) {
                typingProgressThree -> typingProgressOne
                typingProgressOne -> typingProgressTwo
                else -> typingProgressThree
            }
            delay(TYPING_INTERVAL)
        }
    }
}
