package com.hexascribe.chatbotbuilder.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScaffold(
    @DrawableRes toolbarLogoResource: Int? = null,
    toolbarTitle: String? = null,
    toolbarContainerColor: Color = MaterialTheme.colorScheme.background,
    toolbarTextColor: Color = MaterialTheme.colorScheme.onBackground,
    toolbarIconColor: Color = MaterialTheme.colorScheme.onBackground,
    navigationClick: () -> Unit,
    chatScreen: @Composable () -> Unit,
) {

    Column {
        TopAppBar(
            title = {
                toolbarLogoResource?.let { Image(painter = painterResource(id = it), null) }
                toolbarTitle?.let { Text(text = it) }
            },
            colors = TopAppBarDefaults.topAppBarColors().copy(
                containerColor = toolbarContainerColor,
                titleContentColor = toolbarTextColor,
                navigationIconContentColor = toolbarIconColor,
            ),
            navigationIcon = { NavigationIcon(onClick = navigationClick) })
        chatScreen()
    }
}

@Composable
private fun NavigationIcon(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ChatScaffoldPreview() {
    ChatScaffold(toolbarTitle = "Health Chat", navigationClick = {}) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Chat Content")
        }
    }
}
