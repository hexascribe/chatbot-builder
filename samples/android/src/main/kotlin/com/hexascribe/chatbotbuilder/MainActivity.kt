package com.hexascribe.chatbotbuilder

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hexascribe.chatbotbuilder.route.Route
import com.hexascribe.chatbotbuilder.screens.MainScreen
import com.hexascribe.chatbotbuilder.screens.products.FitnessChatScreen
import com.hexascribe.chatbotbuilder.screens.products.HealthChatScreen
import com.hexascribe.chatbotbuilder.screens.products.ToyotaChatScreen
import com.hexascribe.chatbotbuilder.screens.products.WalmartHealthChatScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Route.MAIN.name) {
                composable(Route.MAIN.name) {
                    MainScreen(navController)
                }
                composable(Route.HEALTH_CHAT.name) {
                    HealthChatScreen(navController)
                }
                composable(Route.FITNESS_CHAT.name) {
                    FitnessChatScreen(navController)
                }
                composable(Route.WALMART_HEALTH_CHAT.name) {
                    WalmartHealthChatScreen(navController)
                }
                composable(Route.TOYOTA_CHAT.name) {
                    ToyotaChatScreen(navController)
                }
            }
        }
    }
}
