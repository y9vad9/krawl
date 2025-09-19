package com.y9vad9.krawl.test.integration.brawlify

import com.y9vad9.krawl.brawlify.api.v1.RawBrawlifyApiClient
import io.ktor.client.engine.cio.CIO
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json

class DefaultBrawlifyApiClientIntegrationTest {

    private val client: RawBrawlifyApiClient = RawBrawlifyApiClient.create(
        engine = CIO.create(),
        json = Json {
            ignoreUnknownKeys = false
        },
    )

    @Test
    fun `should return current and upcoming events`() = runTest {
        // WHEN
        val result = client.getEvents()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching events",
        )

        val rotation = result.getOrThrow()
        assertNotNull(
            actual = rotation.active,
            message = "Active events should not be null",
        )
        assertNotNull(
            actual = rotation.upcoming,
            message = "Upcoming events should not be null",
        )
    }

    @Test
    fun `should return list of all brawlers`() = runTest {
        // WHEN
        val result = client.getBrawlers()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching brawlers",
        )

        val brawlers = result.getOrThrow()
        assertTrue(
            actual = brawlers.isNotEmpty(),
            message = "Brawlers list should not be empty",
        )
    }

    @Test
    fun `should return details for a specific brawler`() = runTest {
        // GIVEN
        val allBrawlers = client.getBrawlers().getOrThrow()
        val firstId = allBrawlers.first().id

        // WHEN
        val result = client.getBrawler(
            brawlerId = firstId,
        )

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching brawler by id=$firstId",
        )

        val brawler = result.getOrThrow()
        assertEquals(
            expected = firstId,
            actual = brawler.id,
            message = "Returned brawler should match requested ID",
        )
    }

    @Test
    fun `should return list of all maps`() = runTest {
        // WHEN
        val result = client.getMaps()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching maps",
        )

        val maps = result.getOrThrow()
        assertTrue(
            actual = maps.isNotEmpty(),
            message = "Maps list should not be empty",
        )
    }

    @Test
    fun `should return details for a specific map`() = runTest {
        // GIVEN
        val maps = client.getMaps().getOrThrow()
        val firstId = maps.first().id

        // WHEN
        val result = client.getMap(
            id = firstId,
        )

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching map by id=$firstId",
        )

        val map = result.getOrThrow()
        assertEquals(
            expected = firstId,
            actual = map.id,
            message = "Returned map should match requested ID",
        )
    }

    @Test
    fun `should return list of all game modes`() = runTest {
        // WHEN
        val result = client.getGameModes()

        result.getOrThrow().sortedBy { it.scId }.forEach { gameMode ->
            val constantName = gameMode.name.replace(" ", "_").replace("&", "_AND_").uppercase()
            var i = 0
            val isCheckName = gameMode.name.split(" ").joinToString("") {
                i++
                val capitalized = it.replaceFirstChar { it.uppercase() }
                if (i > 1) capitalized else "is$capitalized"
            }

            println(buildString {
                appendLine("/** Returns `true` if the game mode is [BrawlifyGameModeId.$constantName] */".trimIndent())
                appendLine("public val BrawlifyGameModeId.$isCheckName: Boolean")
                appendLine("    get() = this == BrawlifyGameModeId.$constantName")
            })
        }

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching game modes",
        )

        val modes = result.getOrThrow()
        assertTrue(
            actual = modes.isNotEmpty(),
            message = "Game modes list should not be empty",
        )
    }

    @Test
    fun `should return details for a specific game mode`() = runTest {
        // GIVEN
        val modes = client.getGameModes().getOrThrow()
        val firstId = modes.first().scId

        // WHEN
        val result = client.getGameMode(
            id = firstId,
        )

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching game mode by id=$firstId",
        )

        val mode = result.getOrThrow()
        assertEquals(
            expected = mode.scId,
            actual = firstId,
            message = "Returned game mode should match requested ID",
        )
    }

    @Test
    fun `should return icons`() = runTest {
        // WHEN
        val result = client.getIcons()

        // THEN
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success when fetching icons, " +
                "but got: ${result.exceptionOrNull()?.stackTraceToString()}",
        )

        val icons = result.getOrThrow()
        assertNotNull(
            actual = icons.player,
            message = "Player icons should not be null",
        )
        assertNotNull(
            actual = icons.club,
            message = "Club badges should not be null",
        )
    }
}
