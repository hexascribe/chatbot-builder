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
import com.hexascribe.chatbotbuilder.theme.WalmartHealth

@Composable
fun WalmartHealthChatScreen(navController: NavController) {
    ChatScaffold(
        toolbarLogoResource = R.drawable.ic_walmart_health_toolbar,
        toolbarIconColor = Color.White,
        toolbarContainerColor = Color.WalmartHealth,
        navigationClick = { navController.popBackStack() }
    ) {
        val initialMessage =
            "Hello, here the GPT assistant from Walmart Health, how can I assist you today?"
        val preSeededMessages =
            "You are a helpful chatbot from https://www.sutterhealth.org/ website. You will answer only questions related to healthcare such as workout routines, diet plans, health advice, etc. Answer all questions in a super short and objective way."
        val colors = ChatBot.DefaultColorsBuilder()
            .setInputFieldFocusedIndicatorColor(Color.WalmartHealth)
            .setSendButtonColor(Color.WalmartHealth)
        val chatBot = ChatBot.Builder(BuildConfig.API_KEY)
            .setBotIcon(LocalContext.current, R.drawable.ic_walmart_health)
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
private fun WalmartHealthChatScreenPreview() {
    WalmartHealthChatScreen(rememberNavController())
}
