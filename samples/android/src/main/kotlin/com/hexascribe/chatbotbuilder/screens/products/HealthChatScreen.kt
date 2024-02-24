package com.hexascribe.chatbotbuilder.screens.products

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hexascribe.chatbotbuilder.BuildConfig
import com.hexascribe.chatbotbuilder.ChatBot
import com.hexascribe.chatbotbuilder.core.enums.RoleEnum
import com.hexascribe.chatbotbuilder.theme.ChatScaffold
import com.hexascribe.chatbotbuilder.theme.Health

@Composable
fun HealthChatScreen(navController: NavController) {
    ChatScaffold(
        toolbarTitle = "Health Chat",
        navigationClick = { navController.popBackStack() }
    ) {
        val initialMessage =
            "Hi, I'm Health GPT, here to assist you. Feel free to ask me anything related to health, diet, and other related topics. I'll do my best to help you."
        val preSeededMessages =
            "You are a helpful health assistant, capable of answering any questions related to health, diet, and other related topics."
        val colors = ChatBot.DefaultColorsBuilder()
            .setSendButtonColor(Color.Health)
            .setUserBalloonColor(Color.Health)
            .setSendButtonColor(Color.Health)
            .setInputFieldFocusedIndicatorColor(Color.Health)
        val chatBot = ChatBot.Builder(BuildConfig.API_KEY)
            .setDefaultColorsBuilder(colors)
            .addMessage(RoleEnum.ASSISTANT, initialMessage)
            .addPreSeededMessage(RoleEnum.SYSTEM, preSeededMessages)
            .setInputFieldBorderWidth(1)
            .setLogError(true)
            .build()
        chatBot.ComposeScreen()
    }
}

@Preview
@Composable
private fun HealthChatScreenPreview() {
    HealthChatScreen(rememberNavController())
}
