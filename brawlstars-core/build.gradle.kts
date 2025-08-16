plugins {
    id(conventions.module.core)
}

dependencies {
    jvmIntegrationTestImplementation(libs.kotlin.reflect)
    commonMainApi(projects.common)
}