package me.jakejmattson.airlock

import dev.kord.common.entity.Snowflake
import dev.kord.common.kColor
import me.jakejmattson.discordkt.api.dsl.bot
import me.jakejmattson.discordkt.api.extensions.addInlineField
import me.jakejmattson.discordkt.api.extensions.profileLink

fun main(args: Array<String>) {
    val token = args.firstOrNull() ?: return

    bot(token) {
        prefix {
            ">"
        }

        mentionEmbed {
            val kord = it.discord.kord
            val prefix = it.prefix()

            author {
                val user = kord.getUser(Snowflake(254786431656919051))!!

                icon = user.avatar.url
                name = user.tag
                url = user.profileLink
            }

            title = "Airlock"
            color = it.discord.configuration.theme?.kColor
            description = "\nCurrent prefix is `$prefix`" +
                "\nUse `${prefix}help` to see commands."

            thumbnail {
                kord.getSelf().avatar.url
            }

            addInlineField("", "[[Source]](https://github.com/JakeJMattson/AirLock)")

            footer {
                val versions = it.discord.versions
                text = "1.0.0 - ${versions.library} - ${versions.kord}"
            }
        }
    }
}