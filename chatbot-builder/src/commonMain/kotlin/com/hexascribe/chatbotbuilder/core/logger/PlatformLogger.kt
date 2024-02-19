package com.hexascribe.chatbotbuilder.core.logger

internal interface PlatformLogger {

    fun logError(exception: Throwable)
    fun logError(tag: String, exception: Throwable)
    fun logError(tag: String, message: String, exception: Throwable)

    object Stub : PlatformLogger {
        override fun logError(exception: Throwable) = Unit
        override fun logError(tag: String, exception: Throwable) = Unit
        override fun logError(tag: String, message: String, exception: Throwable) = Unit
    }

    companion object {
        const val TAG_ERROR = "ChatBot-Builder"
    }
}
