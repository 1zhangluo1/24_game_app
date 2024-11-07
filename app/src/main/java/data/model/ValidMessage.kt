package data.model

sealed class ValidMessage {
    object Success : ValidMessage()
    data class Error(val message: String) : ValidMessage()
}