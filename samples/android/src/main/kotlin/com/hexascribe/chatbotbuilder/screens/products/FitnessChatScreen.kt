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
import com.hexascribe.chatbotbuilder.theme.Fitness

@Composable
fun FitnessChatScreen(navController: NavController) {
    ChatScaffold(
        toolbarTitle = "Fitness Chat",
        toolbarContainerColor = Color(0xFF212121),
        toolbarTextColor = Color.White,
        toolbarIconColor = Color.White,
        navigationClick = { navController.popBackStack() }
    ) {
        val initialMessage =
            "Hello, I'm a fitness coach here to assist you with anything related to exercise, gym tips, and much more."
        val preSeededMessages =
            "You are a helpful assistant fitness coach, ready to answer any questions related to fitness, including gym tips, exercises, and more."
        val colors = ChatBot.DarkColorsBuilder()
            .setBackgroundColor(Color(0xFF212121))
            .setInputFieldBackgroundColor(Color(0xFF424242))
            .setSendButtonColor(Color.Fitness)
            .setUserBalloonColor(Color.Fitness)
            .setSendButtonColor(Color.Fitness)
            .setUserBalloonTextColor(Color.White)
            .setBotBalloonColor(Color(0xFF424242))
            .setInputFieldFocusedIndicatorColor(Color.Fitness)
        val chatBot = ChatBot.Builder(BuildConfig.API_KEY)
            .setDarkMode(true)
            .setDarkColorsBuilder(colors)
            .addMessage(RoleEnum.ASSISTANT, initialMessage)
            .addPreSeededMessage(RoleEnum.SYSTEM, preSeededMessages)
            .setLogError(true)
            .build()
        chatBot.ComposeScreen()
    }
}

@Preview
@Composable
private fun FitnessChatScreenPreview() {
    FitnessChatScreen(rememberNavController())
}
