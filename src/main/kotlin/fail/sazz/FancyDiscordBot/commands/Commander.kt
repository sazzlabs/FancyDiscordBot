package fail.sazz.FancyDiscordBot.commands

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class Commander(command: AbstractCommand, event: GuildMessageReceivedEvent, args: List<String>, ) {
    val message: Message = event.message
    val member = event.member
    val sender: Member
        get() {
            if(member != null) {
                return sender
            }
            throw Error("Member is null!")
        }

    val guild: Guild = message.guild
}