package com.hexascribe.chatbotbuilder.di.provider

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

internal actual object HttpClientEngineProvider {
    actual fun provide(): HttpClientEngine {
        return Darwin.create()
    }
}