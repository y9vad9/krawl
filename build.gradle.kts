plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.multiplatform) apply false
    id(conventions.jvm)
    id(conventions.kover)
}

dependencies {
    // -- Coverage Reports Merging --
    kover(projects.brawlstarsApi)
    kover(projects.brawlstarsCore)
    kover(projects.brawlifyApi)
    kover(projects.brawlifyCore)
    kover(projects.brawlifyGamedataCore)
    kover(projects.brawlifyGamedataPlugin)
    kover(projects.integrationTests)
}
