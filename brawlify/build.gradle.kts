plugins {
    alias(libs.plugins.conventions.multiplatform.library)
    alias(libs.plugins.kotlinx.serialization)
}

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
}