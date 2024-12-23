plugins {
    alias(libs.plugins.conventions.multiplatform.library)
    alias(libs.plugins.kotlinx.serialization)
}

group = "com.y9vad9.bsapi"

dependencies {
    // -- Project --
    commonMainApi(projects.core)

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
        groupId = "com.y9vad9.bsapi",
        artifactId = "brawlify",
        version = System.getenv("LIB_VERSION") ?: return@mavenPublishing,
    )

    pom {
        name.set("Brawlify API Client Library")
        description.set("Type-safe library for accessing Brawlify API.")
    }
}