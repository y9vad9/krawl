import kotlinx.kover.gradle.plugin.dsl.AggregationType
import kotlinx.kover.gradle.plugin.dsl.CoverageUnit
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("multiplatform-library-convention")
    id("multiplatform-tests-convention")
    id("kover-convention")
    id("detekt-convention")
}

val libs = the<LibrariesForLibs>()

dependencies {
    commonTestImplementation(libs.kotlin.test)
}

kover.reports.verify.rule {
    minBound(
        minValue = 90,
        coverageUnits = CoverageUnit.LINE,
        aggregationForGroup = AggregationType.COVERED_PERCENTAGE,
    )
}
