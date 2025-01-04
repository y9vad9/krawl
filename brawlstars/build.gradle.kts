plugins {
    id(libs.plugins.conventions.multiplatform.library.get().pluginId)
    alias(libs.plugins.kotlinx.serialization)
}

group = "com.y9vad9.brawlstars"

dependencies {
    // -- My Libs --
    commonMainApi(libs.y9vad9.ktiny.kotlidator)

    // -- Ktor Client (HTTP) --
    commonMainApi(libs.ktor.client.core)
    commonMainImplementation(libs.ktor.client.contentNegotiation)
    commonMainImplementation(libs.ktor.client.json)

    // -- KotlinX Libraries --
    commonMainApi(libs.kotlinx.serialization)
    commonMainApi(libs.kotlinx.datetime)
    commonMainApi(libs.kotlinx.coroutines)

    // -- Tests --
    commonTestImplementation(libs.kotlin.test)
    jvmTestImplementation(libs.ktor.client.java)
    commonTestImplementation(libs.kotlinx.coroutines.test)
}

mavenPublishing {
    coordinates(
        groupId = "com.y9vad9.brawlstars",
        artifactId = "core",
        version = System.getenv("LIB_VERSION") ?: return@mavenPublishing,
    )

    pom {
        name.set("Brawl Stars API Client Library")
        description.set("Type-safe library for accessing Official Brawl Stars API.")
    }
}