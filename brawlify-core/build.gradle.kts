plugins {
    id(conventions.module.core)
}

dependencies {
    commonMainApi(projects.brawlstarsCore)
    commonMainImplementation(projects.brawlifyApi)

    jvmTestImplementation(projects.testFixtures)
    jvmTestImplementation(libs.kotlin.reflect)
}
