package fail.sazz.FancyDiscordBot.commands.fancyCommands

import fail.sazz.FancyDiscordBot.commands.AbstractCommand
import fail.sazz.FancyDiscordBot.commands.Commander
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message

class Ping: AbstractCommand("ping", true) {
    override suspend fun run(commander: Commander) {
        commander.message.channel.sendMessage("Pong!").complete()
    }
}