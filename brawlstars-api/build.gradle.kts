plugins {
    id(conventions.module.api)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    commonMainApi(projects.common)

    commonMainImplementation(libs.kotlinx.coroutines)
    commonMainImplementation(libs.ktor.client.core)
    commonMainImplementation(libs.ktor.serialization.kotlinx.json)
    commonMainImplementation(libs.ktor.client.contentNegotiation)
    commonMainImplementation(libs.kotlinx.serialization.json)
}

kotlin {
    sourceSets.commonTest {
        compilerOptions {
            optIn.add("kotlinx.serialization.ExperimentalSerializationApi")
        }
    }
}
