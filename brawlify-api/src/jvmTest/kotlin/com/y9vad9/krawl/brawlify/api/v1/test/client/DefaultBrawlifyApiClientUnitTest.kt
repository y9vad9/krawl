package com.y9vad9.krawl.brawlify.api.v1.test.client

import com.y9vad9.krawl.brawlify.api.v1.BrawlifyApiClient
import com.y9vad9.krawl.brawlify.api.v1.test.JsonFixturesTest
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.jvm.javaio.toByteReadChannel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.assertDoesNotThrow

class DefaultBrawlifyApiClientUnitTest : JsonFixturesTest() {
    private fun createClientWithFixture(fixturePath: String) = BrawlifyApiClient.create(
        engine = MockEngine {
            respond(
                content = loadFixtureAsStream(fixturePath).toByteReadChannel(),
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
            )
        },
        json = json,
    )

    private fun createClientWithError(status: HttpStatusCode) = BrawlifyApiClient.create(
        engine = MockEngine {
            respond(
                content = """{ "reason": "error" }""",
                status = status,
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
            )
        },
        json = json,
    )

    @Test
    fun `getEvents returns successfully`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/events/multiple.json")

        // WHEN
        val result = client.getEvents()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
        assertNotNull(actual = result.getOrNull())
    }

    @Test
    fun `getEvents does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.InternalServerError)

        // THEN
        assertDoesNotThrow { client.getEvents() }
    }

    @Test
    fun `getBrawlers returns multiple items`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/brawlers/multiple.json")

        // WHEN
        val result = client.getBrawlers()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
        assertEquals(
            expected = result.getOrNull()?.isNotEmpty(),
            actual = true,
        )
    }

    @Test
    fun `getBrawlers does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.ServiceUnavailable)

        // THEN
        assertDoesNotThrow { client.getBrawlers() }
    }

    @Test
    fun `getBrawler returns single item`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/brawlers/single.json")

        // WHEN
        val result = client.getBrawler(16_000_000)

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
        assertNotNull(actual = result.getOrNull())
    }

    @Test
    fun `getBrawler does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.NotFound)

        // THEN
        assertDoesNotThrow { client.getBrawler(16_000_000) }
    }

    @Test
    fun `getMaps returns multiple items`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/maps/multiple.json")

        // WHEN
        val result = client.getMaps()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
        assertEquals(
            expected = true,
            actual = result.getOrNull()?.isNotEmpty(),
        )
    }

    @Test
    fun `getMaps does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.InternalServerError)

        // THEN
        assertDoesNotThrow { client.getMaps() }
    }

    @Test
    fun `getMap returns single item`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/maps/single.json")

        // WHEN
        val result = client.getMap(15_000_013)

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
        assertNotNull(actual = result.getOrNull())
    }

    @Test
    fun `getMap does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.ServiceUnavailable)

        // THEN
        assertDoesNotThrow { client.getMap(15_000_013) }
    }

    @Test
    fun `getGameModes returns multiple items`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/gamemodes/multiple.json")

        // WHEN
        val result = client.getGameModes()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
        assertEquals(
            expected = true,
            actual = result.getOrNull()?.isNotEmpty(),
        )
    }

    @Test
    fun `getGameModes does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.InternalServerError)

        // THEN
        assertDoesNotThrow { client.getGameModes() }
    }

    @Test
    fun `getGameMode returns single item`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/gamemodes/single.json")

        // WHEN
        val result = client.getGameMode(1)

        // THEN
        assertTrue(actual = result.isSuccess)
        assertNotNull(actual = result.getOrNull())
    }

    @Test
    fun `getGameMode does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.NotFound)

        // THEN
        assertDoesNotThrow { client.getGameMode(1) }
    }

    @Test
    fun `getIcons returns multiple items`() = runTest {
        // GIVEN
        val client = createClientWithFixture(fixturePath = "api/v1/icons/multiple.json")

        // WHEN
        val result = client.getIcons()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = result.exceptionOrNull()?.stackTraceToString(),
        )
    }

    @Test
    fun `getIcons does not throw on error`() = runTest {
        // GIVEN
        val client = createClientWithError(status = HttpStatusCode.ServiceUnavailable)

        // THEN
        assertDoesNotThrow { client.getIcons() }
    }
}
