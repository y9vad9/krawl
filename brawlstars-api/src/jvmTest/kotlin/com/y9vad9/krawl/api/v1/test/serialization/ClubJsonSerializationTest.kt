package com.y9vad9.krawl.api.v1.test.serialization

import com.y9vad9.krawl.api.v1.club.Club
import com.y9vad9.krawl.api.v1.club.ClubMember
import com.y9vad9.krawl.api.v1.pagination.PaginatedList
import com.y9vad9.krawl.api.v1.test.JsonFixturesTest
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ClubJsonSerializationTest : JsonFixturesTest() {
    @Test
    fun `check no errors when serializing fixture club returned from API`() {
        // GIVEN
        val path = "api/v1/clubs/example_response.json"
        val fileStream = loadFixtureAsStream(path)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $path into Club"
        ) {
            json.decodeFromStream<Club>(fileStream)
        }
    }

    @Test
    fun `check no errors when serializing fixture non-paginated list of club members list returned from API`() {
        // GIVEN
        val path = "api/v1/clubs/members/no_paging.json"
        val fileStream = loadFixtureAsStream(path)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $path into ClubMember"
        ) {
            json.decodeFromStream<PaginatedList<ClubMember>>(fileStream)
        }
    }

    @Test
    fun `check no errors when serializing fixture paginated club members list returned from API`() {
        // GIVEN
        val basePath = "api/v1/clubs/members"
        val files = listOf(
            "$basePath/paging_1.json",
            "$basePath/paging_2.json",
            "$basePath/paging_3.json",
        )

        // WHEN & THEN
        files.forEach { filePath ->
            assertDoesNotThrow(
                message = "Couldn't serialize $filePath into PaginatedList<ClubMember>"
            ) {
                json.decodeFromStream<PaginatedList<ClubMember>>(
                    stream = loadFixtureAsStream(filePath)
                )
            }
        }
    }
}
