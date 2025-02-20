package org.example.soundlinkchat.domain.socket.dto

data class ChatMessageRequest(
    val userName: String,
    val content: String
)
