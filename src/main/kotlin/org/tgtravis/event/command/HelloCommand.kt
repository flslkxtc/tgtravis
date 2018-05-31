package org.tgtravis.event.command

import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Message
import org.telegram.telegrambots.bots.AbsSender

class HelloCommand(bot: AbsSender,
                   message: Message) : BasicCommand(bot, message, "start") {
    override fun process() {
        bot.execute(SendMessage(message.chatId ,"Hello!"))
    }
}
