package org.example.soundlinkchat.domain.socket.config

import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.stereotype.Component

@Component
class WebSocketInterceptor : ChannelInterceptor {

    @Override
    override fun preSend(
        message: Message<*>,
        channel: MessageChannel
    ): Message<*> {
        val accessor = StompHeaderAccessor.wrap(message)
        val command = accessor.command
        if (command == StompCommand.SUBSCRIBE) {
            println(accessor.destination)
        }
        return message
    }
}