import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    jvmToolchain(11)

    explicitApi = ExplicitApiMode.Strict

    sourceSets {
        all {
            compilerOptions {
                optIn.add("kotlin.time.ExperimentalTime")
            }
        }
    }
}