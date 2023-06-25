package com.hexascribe.chatbotbuilder.logger

internal actual object PlatformLogger {

    actual fun logError(exception: Throwable) {
        logError(TAG_ERROR, exception)
    }

    actual fun logError(tag: String, exception: Throwable) {
        logError(tag, exception.message.orEmpty(), exception)
    }

    actual fun logError(tag: String, message: String, exception: Throwable) {
        println("$tag : $message")
        println(exception)
    }
}
