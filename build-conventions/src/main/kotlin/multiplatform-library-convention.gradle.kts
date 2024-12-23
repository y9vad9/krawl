import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    id("multiplatform-convention")
}

kotlin {
    explicitApi = ExplicitApiMode.Strict
}