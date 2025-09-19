enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.y9vad9.com")
    }
}

rootProject.name = "krawl"

includeBuild("build-conventions")

include(":brawlstars-api", ":brawlstars-core")
include(":brawlify-core", ":brawlify-api")
include(":brawlify-gamedata-core", ":brawlify-gamedata-plugin")
include(":common")
include(":integration-tests")
include(":test-fixtures")