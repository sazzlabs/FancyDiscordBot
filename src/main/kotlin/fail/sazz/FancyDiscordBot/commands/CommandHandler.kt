package fail.sazz.FancyDiscordBot.commands

import fail.sazz.FancyDiscordBot.commands.fancyCommands.Embed
import fail.sazz.FancyDiscordBot.commands.fancyCommands.Ping
import fail.sazz.FancyDiscordBot.commands.fancyCommands.addRole
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class CommandHandler {
    var commandList: MutableList<AbstractCommand> = ArrayList()
    init {
        commandList.add(Ping())
        commandList.add(Embed())
        commandList.add(addRole())
    }

    suspend fun findAndRun(label: String, message: Message, event: GuildMessageReceivedEvent, args: List<String>) {
        commandList.forEach(fun (command: AbstractCommand) {
            val commander = Commander(command, event, args)
            if(command.name != label) return
            if(command.userPermissions().isNotEmpty()) {
                if(!commander.sender.permissions.containsAll(command.userPermissions())) {
                    message.channel.sendMessage("Você não tem permissões suficientes para usar esse comando.").complete()
                    return
                }
            }
            if(command.dev) {
                if(message.author.id != "715967893799436389") {
                    message.channel.sendMessage("Esse comando é apenas para desenvolvedores").complete()
                    return
                }
            }
            command.run(commander)
        })

    }

}