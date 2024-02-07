package com.hexascribe.chatbotbuilder.di.provider

import com.hexascribe.chatbotbuilder.core.logger.PlatformLogger

internal expect object PlatformLoggerProvider {
    fun provide(): PlatformLogger
}
