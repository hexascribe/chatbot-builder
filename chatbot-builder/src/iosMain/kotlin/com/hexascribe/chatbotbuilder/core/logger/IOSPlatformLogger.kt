package com.hexascribe.chatbotbuilder.core.logger

internal class IOSPlatformLogger : PlatformLogger {

    override fun logError(exception: Throwable) {
        logError(PlatformLogger.TAG_ERROR, exception)
    }

    override fun logError(tag: String, exception: Throwable) {
        logError(tag, exception.message.orEmpty(), exception)
    }

    override fun logError(tag: String, message: String, exception: Throwable) {
        println("$tag : $message")
        println(exception)
    }
}
