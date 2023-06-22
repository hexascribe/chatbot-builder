package com.hexascribe.chatbotbuilder.base

/**
 * Enumeration of roles for the [Open AI chat completions API](https://platform.openai.com/docs/api-reference/chat/create).
 * The roles include SYSTEM, USER, and ASSISTANT.
 */
public enum class RoleEnum {
    SYSTEM, USER, ASSISTANT;

    internal companion object {
        fun isAssistant(value: String): Boolean = ASSISTANT.name == value.uppercase()

        fun isUser(value: String): Boolean = USER.name == value.uppercase()
    }
}
