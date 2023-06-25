package com.hexascribe.chatbotbuilder

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.hexascribe.chatbotbuilder.base.RoleEnum

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
    val chatBot = ChatBot.Builder("YOUR_OPEN_AI_KEY")
        .setDarkMode(false)
        .addMessage(RoleEnum.ASSISTANT, "Hi, how can I help you today?")
        .addPreSeededMessage(RoleEnum.SYSTEM, "You are a helpful seller car assistant")
        .setInputFieldBorderWidth(1)
        .setLogError(true)
        .build()
    chatBot.ComposeScreen()
}
