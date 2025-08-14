@file:Suppress("unused")

/**
 * Defines access to all available convention plugin IDs used in this Gradle project.
 *
 * These constants are manually updated and help avoid typos or duplication when referencing
 * convention plugins from the included build `build-conventions`.
 *
 * Example usage:
 * ```kotlin
 * plugins {
 *     id(conventions.jvm)
 *     id(conventions.feature.di)
 *     id(conventions.feature.database)
 * }
 * ```
 */
val conventions: ConventionNamespace = ConventionNamespace()

/**
 * Top-level namespace that organizes convention plugins into meaningful groups
 * (e.g., `jvm`, `multiplatform`, etc.).
 */
class ConventionNamespace internal constructor(
    val jvm: String = "jvm-convention",
    val tests: String = "tests-convention",
    val kover: String = "kover-convention",
    val detekt: String = "detekt-convention",
    val module: ModuleNamespace = ModuleNamespace(),
    val multiplatform: MultiplatformNamespace = MultiplatformNamespace(),
)

class ModuleNamespace(
    public val core: String = "core-convention",
    public val api: String = "api-convention",
)

/**
 * Convention plugins used in Kotlin Multiplatform projects.
 */
class MultiplatformNamespace internal constructor(
    val core: String = "multiplatform-convention",
    /** Convention plugin for setting up shared multiplatform libraries. */
    val library: String = "multiplatform-library-convention",
)
