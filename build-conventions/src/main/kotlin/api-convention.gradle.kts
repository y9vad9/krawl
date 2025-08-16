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

val jvmTarget = kotlin.targets.getByName<KotlinJvmTarget>("jvm")
val commonMainCompilation = jvmTarget.compilations.getByName("main")

val integrationTest by jvmTarget.compilations.creating {
    associateWith(commonMainCompilation)
    defaultSourceSet {
        kotlin.srcDir("src/integrationTest/kotlin")
        resources.srcDir("src/integrationTest/resources")

        dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlin.test.junit)
            implementation(libs.junit.jupiter.engine)

            implementation(libs.kotlinx.coroutines.test)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.contentNegotiation)
            implementation(libs.ktor.client.cio)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}

val integrationTestTask = tasks.register<Test>("integrationTest") {
    dependsOn(integrationTest.compileTaskProvider)
    testClassesDirs = integrationTest.output.classesDirs
    classpath = integrationTest.output.classesDirs + integrationTest.runtimeDependencyFiles
    useJUnit()
}

dependencies {
    commonTestImplementation(libs.kotlin.test)
    commonTestImplementation(libs.ktor.client.mock)
    commonTestImplementation(libs.kotlinx.coroutines.test)
    commonTestImplementation(libs.mockk)
}

tasks.check {
    dependsOn(integrationTestTask)
}

kover.reports.verify.rule {
    minBound(
        minValue = 90,
        coverageUnits = CoverageUnit.LINE,
        aggregationForGroup = AggregationType.COVERED_PERCENTAGE,
    )
}
