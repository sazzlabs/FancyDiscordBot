package fail.sazz.FancyDiscordBot.Bot

import fail.sazz.FancyDiscordBot.commands.CommandHandler
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.utils.cache.CacheFlag
import fail.sazz.FancyDiscordBot.listeners.MessageListener
class FancyDiscordBot {
    val messageListener = MessageListener(this)
    val commandHandler = CommandHandler()
    fun start(token: String) {
        val builder = JDABuilder.createDefault(token)
        // Disable some things.
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setActivity(Activity.playing("Kotlin!"))
        builder.addEventListeners(messageListener)

        println("Iniciando bot...")

        builder.build()
    }
}
