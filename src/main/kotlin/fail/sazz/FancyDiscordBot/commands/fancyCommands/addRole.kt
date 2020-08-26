package fail.sazz.FancyDiscordBot.commands.fancyCommands

import fail.sazz.FancyDiscordBot.commands.AbstractCommand
import fail.sazz.FancyDiscordBot.commands.Commander
import net.dv8tion.jda.api.Permission

class addRole: AbstractCommand("addrole", false, listOf("adicionarcargo")) {
    override fun userPermissions(): List<Permission> {
        return listOf(Permission.MANAGE_ROLES)
    }

    override suspend fun run(commander: Commander) {
        commander.message.channel.sendMessage("yo!")
    }
}