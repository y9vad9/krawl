plugins {
    id(conventions.module.api)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    commonMainApi(projects.common)

    commonMainImplementation(libs.kotlinx.coroutines)
    commonMainApi(libs.ktor.client.core)
    commonMainApi(libs.ktor.serialization.kotlinx.json)
    commonMainImplementation(libs.ktor.client.contentNegotiation)
    commonMainImplementation(libs.kotlinx.serialization.json)

    jvmTestImplementation(projects.testFixtures)
}

kotlin {
    sourceSets {
        commonTest {
            compilerOptions {
                optIn.add("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }
    }
}
