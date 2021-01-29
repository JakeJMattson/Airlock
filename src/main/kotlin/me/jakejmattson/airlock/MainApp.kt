package me.jakejmattson.airlock

import me.jakejmattson.discordkt.api.dsl.bot

fun main(args: Array<String>) {
    val token = args.firstOrNull() ?: return

    bot(token) {
        prefix {
            ">"
        }
    }
}