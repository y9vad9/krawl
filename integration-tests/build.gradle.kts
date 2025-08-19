plugins {
    id(conventions.multiplatform.core)
    id(conventions.multiplatform.tests)
    id(conventions.kover)
}

dependencies {
    commonTestImplementation(libs.kotlin.test)
    commonTestImplementation(libs.kotlinx.coroutines.test)
    commonTestImplementation(libs.ktor.client.core)
    commonTestImplementation(libs.ktor.serialization.kotlinx.json)
    commonTestImplementation(libs.ktor.client.contentNegotiation)
    commonTestImplementation(libs.ktor.client.cio)
    commonTestImplementation(libs.kotlinx.serialization.json)

    commonTestImplementation(projects.brawlstarsApi)
    commonTestImplementation(projects.brawlifyApi)
}
