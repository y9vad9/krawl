plugins {
    id(conventions.multiplatform.library)
}

dependencies {
    commonMainImplementation(libs.ktor.client.core)
    commonMainImplementation(libs.ktor.serialization.kotlinx.json)
    commonMainImplementation(libs.ktor.client.contentNegotiation)
    commonMainImplementation(libs.ktor.client.cio)
    commonMainImplementation(libs.kotlinx.serialization.json)
}