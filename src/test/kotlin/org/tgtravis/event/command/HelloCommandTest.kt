package org.tgtravis.event.command

import org.mockito.Matchers
import org.mockito.Mockito.*
import org.telegram.telegrambots.api.methods.send.SendMessage
import kotlin.test.Test

class HelloCommandTest : AbstractCommandTest() {

    @Test
    fun respondsToStartMessage() {
        mockMessage("start")
        val command = HelloCommand(bot, message)
        command.process()
        verify(bot).execute(SendMessage(message.chatId, Matchers.anyString()))
    }
}
