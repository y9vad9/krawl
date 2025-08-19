package com.y9vad9.krawl.brawlify.api.v1.test.serialization

import com.y9vad9.krawl.brawlify.api.v1.brawler.BrawlifyBrawler
import com.y9vad9.krawl.brawlify.api.v1.internal.ItemsResponse
import com.y9vad9.krawl.brawlify.api.v1.test.JsonFixturesTest
import kotlin.test.Test
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.assertDoesNotThrow

class BrawlerJsonSerializationTest : JsonFixturesTest() {
    @Test
    fun `check no errors when serializing gamemodes from fixtures`() {
        // GIVEN
        val filePath = "api/v1/brawlers/multiple.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into ItemsResponse<BrawlifyBrawler>"
        ) {
            json.decodeFromStream<ItemsResponse<BrawlifyBrawler>>(stream)
        }
    }

    @Test
    fun `check no errors when serializing single gamemode from fixtures`() {
        // GIVEN
        val filePath = "api/v1/brawlers/single.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into BrawlifyBrawler"
        ) {
            json.decodeFromStream<BrawlifyBrawler>(stream)
        }
    }
}