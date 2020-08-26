package fail.sazz.FancyDiscordBot.commands.fancyCommands

import fail.sazz.FancyDiscordBot.commands.AbstractCommand
import net.dv8tion.jda.api.entities.Message


class Ping: AbstractCommand("ping", true) {
    override suspend fun run(message: Message) {
        message.channel.sendMessage("Pong!").complete()
    }
}