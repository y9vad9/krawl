package com.y9vad9.krawl.api.v1.test.serialization

import com.y9vad9.krawl.api.v1.brawler.Brawler
import com.y9vad9.krawl.api.v1.pagination.PaginatedList
import com.y9vad9.krawl.api.v1.test.JsonFixturesTest
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class BrawlerJsonSerializationTest : JsonFixturesTest() {
    @Test
    fun `check no errors when serializing fixture brawler returned from API`() {
        // GIVEN
        val path = "api/v1/brawlers/id/example_response.json"
        val fileStream = loadFixtureAsStream(path)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $path into Brawler"
        ) {
            json.decodeFromStream<Brawler>(fileStream)
        }
    }

    @Test
    fun `check no errors when serializing fixture non-paginated brawlers list returned from API`() {
        // GIVEN
        val path = "api/v1/brawlers/no_paging.json"
        val fileStream = loadFixtureAsStream(path)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $path into Brawler"
        ) {
            json.decodeFromStream<PaginatedList<Brawler>>(fileStream)
        }
    }

    @Test
    fun `check no errors when serializing fixture paginated brawlers list returned from API`() {
        // GIVEN
        val basePath = "api/v1/brawlers"
        val files = listOf(
            "$basePath/paging_1.json",
            "$basePath/paging_2.json",
            "$basePath/paging_3.json",
        )

        // WHEN & THEN
        files.forEach { filePath ->
            assertDoesNotThrow(
                message = "Couldn't serialize $filePath into PaginatedList<Brawler>"
            ) {
                json.decodeFromStream<PaginatedList<Brawler>>(
                    stream = loadFixtureAsStream(filePath)
                )
            }
        }
    }
}
