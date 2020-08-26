package fail.sazz.FancyDiscordBot

import fail.sazz.FancyDiscordBot.Bot.FancyDiscordBot
import java.io.File

fun main() {
    val tokenFile = File("./token.txt")
    val token = tokenFile.readText()
    val fancyDiscordBot = FancyDiscordBot()
    fancyDiscordBot.start(token)
}