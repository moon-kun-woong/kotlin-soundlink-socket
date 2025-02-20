package org.example.soundlinkchat.domain.socket.controller

import org.example.soundlinkchat.domain.socket.dto.ChatMessageRequest
import org.example.soundlinkchat.domain.socket.dto.ChatMessageResponse
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {
    @MessageMapping("/chat")
    @SendTo("/subscribe/chat")
    fun sendMessage(request: ChatMessageRequest,): ChatMessageResponse {
        if (request.userName.equals("trap")){
            throw RuntimeException("트랩입니다.")
        }
        return ChatMessageResponse(request.userName,request.content)
    }

    @MessageExceptionHandler
    fun handleException(e: RuntimeException){
        println("Exception : ${e.message}")
    }
}