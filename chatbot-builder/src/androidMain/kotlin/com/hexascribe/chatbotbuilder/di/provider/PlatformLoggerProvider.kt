package com.hexascribe.chatbotbuilder.di.provider

import com.hexascribe.chatbotbuilder.core.logger.AndroidPlatformLogger
import com.hexascribe.chatbotbuilder.core.logger.PlatformLogger

internal actual object PlatformLoggerProvider {
    actual fun provide(): PlatformLogger {
        return AndroidPlatformLogger()
    }
}
