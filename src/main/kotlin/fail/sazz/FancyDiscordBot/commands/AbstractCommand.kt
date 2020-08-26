package fail.sazz.FancyDiscordBot.commands

import net.dv8tion.jda.api.Permission

abstract class AbstractCommand(open val name: String, open val dev: Boolean, open val aliases: List<String> = listOf()) {
    open fun userPermissions(): List<Permission> {
        return listOf()
    }

    abstract suspend fun run(commander: Commander)
}