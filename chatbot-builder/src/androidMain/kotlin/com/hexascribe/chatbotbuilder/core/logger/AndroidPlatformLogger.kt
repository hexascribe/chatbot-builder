package com.hexascribe.chatbotbuilder.core.logger

import android.util.Log

internal class AndroidPlatformLogger : PlatformLogger {

    override fun logError(exception: Throwable) {
        logError(PlatformLogger.TAG_ERROR, exception)
    }

    override fun logError(tag: String, exception: Throwable) {
        logError(tag, exception.message.orEmpty(), exception)
    }

    override fun logError(tag: String, message: String, exception: Throwable) {
        Log.e(tag, message, exception)
    }
}
