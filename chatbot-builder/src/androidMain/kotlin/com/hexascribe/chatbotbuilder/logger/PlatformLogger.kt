package com.hexascribe.chatbotbuilder.logger

import android.util.Log

internal actual object PlatformLogger {

    actual fun logError(exception: Throwable) {
        logError(TAG_ERROR, exception)
    }

    actual fun logError(tag: String, exception: Throwable) {
        logError(tag, exception.message.orEmpty(), exception)
    }

    actual fun logError(tag: String, message: String, exception: Throwable) {
        Log.e(tag, message, exception)
    }
}
