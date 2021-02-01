group = "me.jakejmattson"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.30"

    id("com.github.johnrengelman.shadow") version "6.0.0"
    id("com.github.ben-manes.versions") version "0.36.0"
}

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.22.0-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    shadowJar {
        archiveFileName.set("AirLock.jar")
        manifest {
            attributes(
                "Main-Class" to "me.jakejmattson.airlock.MainAppKt"
            )
        }
    }
}
