package me.jakejmattson.airlock.data

import me.jakejmattson.discordkt.api.dsl.Data

data class Configuration(val botOwner: Long = 254786431656919051,
                         val guildConfigurations: MutableMap<Long, GuildConfiguration> = mutableMapOf()) : Data("config/config.json") {
    operator fun get(id: Long) = guildConfigurations[id]
}

data class GuildConfiguration(var prefix: String)
