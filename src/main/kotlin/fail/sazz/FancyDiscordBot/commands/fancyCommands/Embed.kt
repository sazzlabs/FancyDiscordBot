package fail.sazz.FancyDiscordBot.commands.fancyCommands

import fail.sazz.FancyDiscordBot.commands.AbstractCommand
import fail.sazz.FancyDiscordBot.commands.Commander
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message
import java.awt.Color

class Embed: AbstractCommand("embed", false) {
    override suspend fun run(commander: Commander) {
        val embed = EmbedBuilder()
        embed.setTitle("Isso é o titulo do Embed!")
        embed.setDescription("Isso é a descrição do Embed!")
        embed.addField("Isso é um Field!", "Isso é o valor do field!", true)
        embed.setFooter("Isso é o footer!")
        embed.setColor(Color.RED)

        commander.message.channel.sendMessage(embed.build()).queue()
    }
}