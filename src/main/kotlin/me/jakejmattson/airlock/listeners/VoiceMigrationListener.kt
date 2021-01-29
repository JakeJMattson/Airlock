package me.jakejmattson.airlock.listeners

import dev.kord.core.behavior.edit
import dev.kord.core.event.user.VoiceStateUpdateEvent
import me.jakejmattson.discordkt.api.dsl.listeners

fun voiceMigration() = listeners {
    on<VoiceStateUpdateEvent> {
        println("Update detected")

        val member = state.getMember()

        println(member.username)

        if (member.isBot)
            return@on

        val old = old ?: return@on
        val new = state

        if (!old.isDeafened && new.isDeafened) {
            println("Moving to ${new.getGuild().afkChannelId}")

            member.edit {
                voiceChannelId = new.getGuild().afkChannelId
            }
        }
    }
}