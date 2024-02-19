package com.hexascribe.chatbotbuilder.di

import com.hexascribe.chatbotbuilder.core.logger.PlatformLogger
import com.hexascribe.chatbotbuilder.data.api.OpenAiApi
import com.hexascribe.chatbotbuilder.di.provider.HttpClientProvider
import com.hexascribe.chatbotbuilder.di.provider.PlatformLoggerProvider
import com.hexascribe.chatbotbuilder.domain.converter.SendChatMessageDtoConverter
import com.hexascribe.chatbotbuilder.domain.usecase.SendChatMessageUseCase
import org.koin.dsl.module

internal object SdkModule {

    fun getModule(apiKey: String, isLogErrorEnabled: Boolean) = module {
        single { HttpClientProvider.provide(apiKey) }
        factory { PlatformLogger }
        factory { OpenAiApi(get(), get()) }
        factory { SendChatMessageUseCase(get(), get()) }
        factory { SendChatMessageDtoConverter() }
        factory { if (isLogErrorEnabled) PlatformLoggerProvider.provide() else PlatformLogger.Stub }
    }
}
