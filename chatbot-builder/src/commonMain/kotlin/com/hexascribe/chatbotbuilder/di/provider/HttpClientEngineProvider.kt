package com.hexascribe.chatbotbuilder.di.provider

import io.ktor.client.engine.HttpClientEngine

internal expect object HttpClientEngineProvider {
    fun provide(): HttpClientEngine
}
