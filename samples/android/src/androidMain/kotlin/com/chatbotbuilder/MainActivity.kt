package com.chatbotbuilder

import ChatBot
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import base.RoleEnum

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val chatkit = ChatBot.Builder("")
                .setDarkMode(true)
                .addMessage(RoleEnum.USER, "Teste")
                .addPreSeededMessage(RoleEnum.SYSTEM, "Você é um assistente virtual que somente tira dúvidas relacionadas a programação")
                .setInputFieldBorderWidth(1)
                .build()

            chatkit.ChatScreen()
        }
    }
}
