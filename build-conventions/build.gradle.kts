plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    api(libs.pluginClasspath.kotlin)
    api(libs.pluginClasspath.kover)
    api(libs.pluginClasspath.detekt)
    api(libs.pluginClasspath.dokka)
    api(files((libs).javaClass.superclass.protectionDomain.codeSource.location))
}