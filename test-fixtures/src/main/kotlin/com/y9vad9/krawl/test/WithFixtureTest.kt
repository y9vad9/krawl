package com.y9vad9.krawl.test

import java.io.InputStream

abstract class WithFixtureTest {
    /**
     * Loads a test fixture file from the `fixtures/` directory in the test resources as an [InputStream].
     *
     * The provided [path] is relative to the `fixtures/` directory. For example:
     * ```
     * val stream = loadFixtureAsStream("v1/events/multiple.json")
     * ```
     * will load the file located at:
     * ```
     * /test-fixtures/src/main/resources/fixtures/v1/events/multiple.json
     * ```
     *
     * @param path The relative path to the fixture file, starting after `fixtures/`.
     * @return An [InputStream] for the fixture file.
     * @throws IllegalArgumentException if the fixture file cannot be found.
     */
    protected fun loadFixtureAsStream(path: String): InputStream {
        val resourcePath = "/fixtures/api/brawlify/$path"
        return this::class.java.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Fixture not found: $resourcePath")
    }
}
