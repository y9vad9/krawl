import org.jetbrains.kotlin.gradle.dsl.*

plugins {
    id("multiplatform-convention")
    id("detekt-convention")
    id("kover-convention")
    id("org.jetbrains.dokka")
}

kotlin {
    explicitApi()
}
