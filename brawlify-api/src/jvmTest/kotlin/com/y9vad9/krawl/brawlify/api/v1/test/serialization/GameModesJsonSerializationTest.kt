package com.y9vad9.krawl.brawlify.api.v1.test.serialization

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameMode
import com.y9vad9.krawl.brawlify.api.v1.internal.ItemsResponse
import kotlin.test.Test
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.assertDoesNotThrow

class GameModesJsonSerializationTest : com.y9vad9.krawl.test.WithJsonFixturesTest() {

    @Test
    fun `check no errors when serializing gamemodes from fixtures`() {
        // GIVEN
        val filePath = "v1/gamemodes/multiple.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into ItemsResponse<BrawlifyGameMode>"
        ) {
            json.decodeFromStream<ItemsResponse<RawBrawlifyGameMode>>(stream)
        }
    }

    @Test
    fun `check no errors when serializing single gamemode from fixtures`() {
        // GIVEN
        val filePath = "v1/gamemodes/single.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into BrawlifyGameMode"
        ) {
            json.decodeFromStream<RawBrawlifyGameMode>(stream)
        }
    }
}
