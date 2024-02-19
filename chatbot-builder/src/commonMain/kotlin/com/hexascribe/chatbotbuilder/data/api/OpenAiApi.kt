package com.hexascribe.chatbotbuilder.data.api

import com.hexascribe.chatbotbuilder.core.logger.PlatformLogger
import com.hexascribe.chatbotbuilder.data.dto.ChatMessageDto
import com.hexascribe.chatbotbuilder.data.dto.ErrorDto
import com.hexascribe.chatbotbuilder.data.dto.SendChatMessageDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.preparePost
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.HttpStatement
import io.ktor.http.isSuccess
import io.ktor.utils.io.errors.IOException

internal class OpenAiApi(
    private val httpClient: HttpClient,
    private val platformLogger: PlatformLogger,
) {

    suspend fun sendMessage(sendChatMessageDto: SendChatMessageDto): Result<ChatMessageDto> {
        val httpRequestBuilder = HttpRequestBuilder().apply {
            url("v1/chat/completions")
            setBody(sendChatMessageDto)
        }
        val httpStatement = httpClient.preparePost(httpRequestBuilder)
        return onApiExecute(httpStatement)
    }

    private suspend inline fun <reified T> onApiExecute(httpStatement: HttpStatement): Result<T> {
        return try {
            httpStatement.execute().toResult()
        } catch (responseException: ResponseException) {
            responseException.toResult()
        } catch (iOException: IOException) {
            iOException.toResult()
        }
    }

    private suspend inline fun <reified T> HttpResponse.toResult(): Result<T> {
        return if (this.status.isSuccess()) {
            Result.success(this.body())
        } else {
            val errorMessage = runCatching { this.body<ErrorDto>() }
                .getOrNull()
                ?.error
                ?.message ?: "Request failed with status code: ${this.status.value}"
            val exception = IllegalStateException(errorMessage)
            platformLogger.logError(exception)
            Result.failure(exception)
        }
    }

    private fun <T> Exception.toResult(): Result<T> {
        platformLogger.logError(this)
        return Result.failure(this)
    }
}
