package com.hexascribe.chatbotbuilder

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.hexascribe.chatbotbuilder.core.enums.RoleEnum

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatScreen()
        }
    }
}

@Composable
fun ChatScreen() {
    val chatBot = ChatBot.Builder(BuildConfig.API_KEY)
        .setDarkMode(false)
        .addMessage(RoleEnum.ASSISTANT, "Hi, how can I help you today?")
        .addPreSeededMessage(RoleEnum.SYSTEM, "You are a helpful seller car assistant")
        .setInputFieldBorderWidth(1)
        .setLogError(true)
        .build()
    chatBot.ComposeScreen()
}
