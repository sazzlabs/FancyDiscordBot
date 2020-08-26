package fail.sazz.FancyDiscordBot.listeners

import fail.sazz.FancyDiscordBot.Bot.FancyDiscordBot
import kotlinx.coroutines.*
import net.dv8tion.jda.api.entities.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.util.regex.Pattern
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class MessageListener(val fancyBot: FancyDiscordBot): ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        val prefix = "!"
        val message = event.message
        var member = event.member
        if(message.author.isBot) return
        if(!message.contentRaw.startsWith(prefix)) return
        val commandRegex = Regex("^" + Pattern.quote(prefix) + "[A-z0-9]+.*")
        // 0: Comando e o resto são os verdadeiros argumentos!
        val args: List<String> = message.contentRaw.split(Pattern.compile("\\s+"))
        if(message.contentRaw.matches(commandRegex)) {
            val commandLabel = message.contentDisplay.split(" ")[0].trim().substring(prefix.length)
            var job: Job = Job()
            var scope = CoroutineScope(job)
            scope.launch() {
                if (member != null) {
                    fancyBot.commandHandler.findAndRun(commandLabel, message, event, args)
                }
            }
        }
    }

}