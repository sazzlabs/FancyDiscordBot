package fail.sazz.FancyDiscordBot.commands

import fail.sazz.FancyDiscordBot.commands.fancyCommands.Ping
import net.dv8tion.jda.api.entities.Message

class CommandHandler {
    var commandList: MutableList<AbstractCommand> = ArrayList()
    init {
        commandList.add(Ping())
    }

    suspend fun findAndRun(label: String, message: Message) {
        for(command in commandList) {
            // Se o comando não for encontrado, ele vai retornar silenciosamente.
            if(command.name != label) return;
            // O comando é para apenas o desenvolvedor? E o usuário que executou é desenvolvedor? Se não, ele vai retornar.
            if(command.dev) {
                if(message.author.id != "326123612153053184") {
                    message.channel.sendMessage("Esse comando é apenas para desenvolvedores")
                    return
                }
            }
            command.run(message)
        }
    }



}