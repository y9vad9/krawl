@file:OptIn(ExperimentalSerializationApi::class)

package com.y9vad9.krawl.api.v1.test.serialization

import com.y9vad9.krawl.api.v1.battle.BattleRecord
import com.y9vad9.krawl.api.v1.pagination.PaginatedList
import com.y9vad9.krawl.api.v1.test.JsonFixturesTest
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class BattleJsonSerializationTestJson : JsonFixturesTest() {
    @Test
    fun `check no errors when serializing test fixtures battlelog`() {
        // GIVEN
        val basePath = "/api/v1/players/battlelog"
        val files = listOf(
            "$basePath/example_response_1.json",
            "$basePath/example_response_2.json",
            "$basePath/example_response_3.json",
        )

        // WHEN & THEN
        files.forEach { filePath ->
            assertDoesNotThrow(
                message = "Couldn't serialize $filePath into PaginatedList<BattleRecord>"
            ) {
                json.decodeFromStream<PaginatedList<BattleRecord>>(
                    stream = loadFixtureAsStream(filePath)
                )
            }
        }
    }
}
