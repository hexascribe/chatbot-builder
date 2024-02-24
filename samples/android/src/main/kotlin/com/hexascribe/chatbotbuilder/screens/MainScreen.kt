package com.hexascribe.chatbotbuilder.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hexascribe.chatbotbuilder.route.Route
import com.hexascribe.chatbotbuilder.theme.Fitness
import com.hexascribe.chatbotbuilder.theme.Health
import com.hexascribe.chatbotbuilder.theme.Toyota
import com.hexascribe.chatbotbuilder.theme.WalmartHealth

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Color.White
        Text(text = "ChatBot Builder Sample")
        Spacer(modifier = Modifier.height(24.dp))
        ChatButton(text = "Health", backgroundColor = Color.Health) {
            navController.navigate(Route.HEALTH_CHAT.name)
        }
        ChatButton(text = "Fitness", backgroundColor = Color.Fitness) {
            navController.navigate(Route.FITNESS_CHAT.name)
        }
        ChatButton(text = "Walmart Health", backgroundColor = Color.WalmartHealth) {
            navController.navigate(Route.WALMART_HEALTH_CHAT.name)
        }
        ChatButton(text = "Toyota", backgroundColor = Color.Toyota) {
            navController.navigate(Route.TOYOTA_CHAT.name)
        }
    }
}

@Composable
private fun ChatButton(text: String, backgroundColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(containerColor = backgroundColor),
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(text = text)
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
private fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
