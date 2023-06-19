package base

enum class RoleEnum {
    SYSTEM, USER, ASSISTANT;

    internal companion object {
        fun isAssistant(value: String): Boolean = ASSISTANT.name == value.uppercase()

        fun isUser(value: String): Boolean = USER.name == value.uppercase()
    }
}
