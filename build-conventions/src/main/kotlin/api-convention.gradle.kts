import kotlinx.kover.gradle.plugin.dsl.AggregationType
import kotlinx.kover.gradle.plugin.dsl.CoverageUnit
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.getByName
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget

plugins {
    id("multiplatform-library-convention")
    id("multiplatform-tests-convention")
    id("kover-convention")
    id("detekt-convention")
}

val libs = the<LibrariesForLibs>()

dependencies {
    commonTestImplementation(libs.kotlin.test)
    commonTestImplementation(libs.ktor.client.mock)
    commonTestImplementation(libs.kotlinx.coroutines.test)
    "jvmTestImplementation"(libs.mockk)
}

kover {
    reports.verify.rule {
        minBound(
            minValue = 90,
            coverageUnits = CoverageUnit.LINE,
            aggregationForGroup = AggregationType.COVERED_PERCENTAGE,
        )
    }
}
