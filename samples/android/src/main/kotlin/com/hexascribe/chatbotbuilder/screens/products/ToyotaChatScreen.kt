package com.hexascribe.chatbotbuilder.screens.products

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hexascribe.chatbotbuilder.BuildConfig
import com.hexascribe.chatbotbuilder.ChatBot
import com.hexascribe.chatbotbuilder.R
import com.hexascribe.chatbotbuilder.core.enums.RoleEnum
import com.hexascribe.chatbotbuilder.theme.ChatScaffold
import com.hexascribe.chatbotbuilder.theme.Toyota

@Composable
fun ToyotaChatScreen(navController: NavController) {
    ChatScaffold(
        toolbarLogoResource = R.drawable.ic_toyota_toolbar,
        navigationClick = { navController.popBackStack() }
    ) {
        val initialMessage =
            "Hello there! Let me know what your budget is, if you want to buy or lease, and any other details that can help me find the perfect vehicle for you."
        val preSeededMessages =
            "You are a helpful Toyota salesman. Your main goal is to find the best suitable vehicle for the customer. Answer as concisely as possible."
        val colors = ChatBot.DefaultColorsBuilder()
            .setInputFieldFocusedIndicatorColor(Color.Toyota)
            .setSendButtonColor(Color.Toyota)
        val chatBot = ChatBot.Builder(BuildConfig.API_KEY)
            .setBotIcon(LocalContext.current, R.drawable)
            .setDefaultColorsBuilder(colors)
            .addMessage(RoleEnum.ASSISTANT, initialMessage)
            .addPreSeededMessage(RoleEnum.SYSTEM, preSeededMessages)
            .setLogError(true)
            .build()
        chatBot.ComposeScreen()
    }
}

@Preview
@Composable
private fun ToyotaChatScreenPreview() {
    ToyotaChatScreen(rememberNavController())
}
