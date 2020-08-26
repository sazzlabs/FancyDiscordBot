package fail.sazz.FancyDiscordBot.listeners

import fail.sazz.FancyDiscordBot.Bot.FancyDiscordBot
import kotlinx.coroutines.*
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.util.regex.Pattern
import net.dv8tion.jda.api.entities.Message

class MessageListener(val fancyBot: FancyDiscordBot): ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val prefix = "!"
        val message = event.message
        val channel = event.channel
        if(message.author.isBot) return
        if(!message.contentRaw.startsWith(prefix)) return
        val commandRegex = Regex("^" + Pattern.quote(prefix) + "[A-z0-9]+.*")

        if(message.contentRaw.matches(commandRegex)) {
            val commandLabel = message.contentDisplay.split(" ")[0].trim().substring(prefix.length)
            var job: Job = Job()
            var scope = CoroutineScope(job)
            scope.launch() {
                fancyBot.commandHandler.findAndRun(commandLabel, message)
            }
        }
    }

}