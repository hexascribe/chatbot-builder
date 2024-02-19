package com.hexascribe.chatbotbuilder.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ErrorDetailsDto(
    @SerialName("message") val message: String,
    @SerialName("type") val type: String,
    @SerialName("param") val param: String?,
    @SerialName("code") val code: String,
)
