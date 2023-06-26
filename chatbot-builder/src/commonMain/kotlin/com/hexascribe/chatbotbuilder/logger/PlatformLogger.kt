package com.hexascribe.chatbotbuilder.logger

internal expect object PlatformLogger {

    fun logError(exception: Throwable)
    fun logError(tag: String, exception: Throwable)
    fun logError(tag: String, message: String, exception: Throwable)
}

internal const val TAG_ERROR = "ChatBot-Builder Error"
