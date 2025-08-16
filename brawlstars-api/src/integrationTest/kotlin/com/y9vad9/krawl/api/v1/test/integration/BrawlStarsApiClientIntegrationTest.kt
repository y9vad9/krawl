package com.y9vad9.krawl.api.v1.test.integration

import com.y9vad9.krawl.ExperimentalKrawlApi
import com.y9vad9.krawl.api.v1.BrawlStarsApiClient
import com.y9vad9.krawl.api.v1.battle.BattleRecord
import com.y9vad9.krawl.api.v1.club.Club
import com.y9vad9.krawl.api.v1.club.ClubMember
import com.y9vad9.krawl.api.v1.pagination.PaginatedList
import com.y9vad9.krawl.api.v1.player.Player
import com.y9vad9.krawl.api.v1.ranking.ClubRanking
import com.y9vad9.krawl.api.v1.rateLimited
import io.ktor.client.engine.cio.CIO
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json

class BrawlStarsApiClientIntegrationTest {
    @OptIn(ExperimentalKrawlApi::class)
    private val client: BrawlStarsApiClient = BrawlStarsApiClient.createWithRoyaleApiProxy(
        engine = CIO.create {},
        bearerToken = System.getenv("BRAWLSTARS_API_KEY")
            ?: error("Missing BRAWLSTARS_API_KEY env variable for tests"),
        json = Json {
            // Ensure we parse all fields, fail if unknown
            ignoreUnknownKeys = false
        },
    ).rateLimited(
        maxRequests = 5,
        per = 1.seconds,
    )

    @Test
    fun `should return player for valid tag`() = runTest {
        // Given
        val validTag = "#2GRVVCYUQG" // known sample tag, must exist in RoyaleAPI test dataset

        // When
        val result = client.getPlayer(tag = validTag)

        // Then
        assertTrue(
            actual = result.isSuccess,
            message = "Expected success for valid player tag",
        )
        val player: Player? = result.getOrThrow()
        assertNotNull(
            actual = player,
            message = "Player should not be null for valid tag",
        )
        assertEquals(
            expected = validTag,
            actual = player.tag,
            message = "Returned tag should match",
        )
    }

    @Test
    fun `should fail for invalid player tag`() = runTest {
        // Given
        val invalidTag = "#INVALID123"

        // When
        val result = client.getPlayer(tag = invalidTag)

        // Then
        assertTrue(
            actual = result.isFailure || result.getOrNull() == null,
            message = "Expected failure or null for invalid tag",
        )
    }

    @Test
    fun `should return club for valid tag`() = runTest {
        // Given
        val clubTag = "#80GP0LRL0" // known high-ranking club tag

        // When
        val result = client.getClub(tag = clubTag)

        // Then
        assertTrue(result.isSuccess)
        val club: Club? = result.getOrThrow()
        assertNotNull(club)
        assertEquals(
            expected = clubTag,
            actual = club.tag,
        )
    }

    @Test
    fun `should fail for invalid club tag`() = runTest {
        // Given
        val invalidTag = "#INVALIDCLUB"

        // When
        val result = client.getClub(tag = invalidTag)

        // Then
        assertTrue(result.isFailure || result.getOrNull() == null)
    }

    @Test
    fun `should retrieve club members`() = runTest {
        // Given
        val clubTag = "#80GP0LRL0"

        // When
        val result = client.getClubMembers(tag = clubTag)

        // Then
        assertTrue(result.isSuccess)
        val members: List<ClubMember>? = result.getOrThrow()
        assertNotNull(members)
        assertTrue(members.isNotEmpty(), "Club should have members")
    }

    @Test
    fun `should iterate top clans and fetch members battle logs`() = runTest {
        // Given
        val rankingResult = client.getClubRanking(countryCode = "global")
        assertTrue(rankingResult.isSuccess, "Could not fetch club rankings")
        val ranking: PaginatedList<ClubRanking> = rankingResult.getOrThrow()
        assertTrue(ranking.isNotEmpty(), "Expected at least one top clan")

        // When
        for (clubRanking in ranking.take(3)) { // limit for test speed
            val membersResult = client.getClubMembers(tag = "#${clubRanking.tag}")
            if (membersResult.isFailure) continue
            val members: List<ClubMember>? = membersResult.getOrThrow()
            if (members.isNullOrEmpty()) continue

            for (member in members.take(2)) { // limit per test run
                val battleLogResult = client.getPlayerBattleLog(tag = "#${member.tag}")
                assertTrue(
                    battleLogResult.isSuccess,
                    "Expected battle log fetch to succeed for ${member.tag}",
                )
                val battles: List<BattleRecord>? = battleLogResult.getOrThrow()
                assertNotNull(battles, "Battle log should not be null for ${member.tag}")
            }
        }

        // Then
        // If we reached here, all battle logs parsed successfully
    }

    @Test
    fun `should fetch brawler ranking successfully`() = runTest {
        // GIVEN
        val brawlerId = 16_000_000 // example: Shelly
        val countryCode = "global"

        // WHEN
        val result = client.getBrawlerRanking(
            brawlerId = brawlerId,
            countryCode = countryCode,
            after = null,
            before = null,
            limit = 10,
        )

        // THEN
        assertTrue(result.isSuccess, "Expected success fetching brawler ranking")
        val ranking = result.getOrThrow()
        assertNotNull(ranking, "Ranking should not be null")
        assertTrue(ranking.isNotEmpty(), "Expected at least one player in ranking")
    }

    @Test
    fun `should fetch player ranking successfully`() = runTest {
        // GIVEN
        val countryCode = "global"

        // WHEN
        val result = client.getPlayerRanking(
            countryCode = countryCode,
            after = null,
            before = null,
            limit = 10,
        )

        // THEN
        assertTrue(result.isSuccess, "Expected success fetching player ranking")
        val ranking = result.getOrThrow()
        assertNotNull(ranking, "Ranking should not be null")
        assertTrue(ranking.isNotEmpty(), "Expected at least one player")
    }

    @Test
    fun `should fetch club ranking successfully`() = runTest {
        // GIVEN
        val countryCode = "global"

        // WHEN
        val result = client.getClubRanking(
            countryCode = countryCode,
            after = null,
            before = null,
            limit = 10,
        )

        // THEN
        assertTrue(result.isSuccess, "Expected success fetching club ranking")
        val ranking = result.getOrThrow()
        assertNotNull(ranking, "Club ranking must not be null")
        assertTrue(ranking.isNotEmpty(), "Expected at least one club")
    }

    @Test
    fun `should fetch event rotation successfully`() = runTest {
        // GIVEN
        // no parameters

        // WHEN
        val result = client.getEventsRotation()

        // THEN
        assertTrue(result.isSuccess, "Expected success fetching event rotation")
        val events = result.getOrThrow()
        assertNotNull(events, "Events list must not be null")
        assertTrue(events.isNotEmpty(), "Expected at least one event")
    }

    @Test
    fun `should return player ranking for global`() = runTest {
        // GIVEN
        val countryCode = "global"

        // WHEN
        val result = client.getPlayerRanking(countryCode = countryCode)

        // THEN
        assertTrue(result.isSuccess, "Expected success for player ranking in $countryCode")
        val ranking = result.getOrThrow()
        assertNotNull(ranking, "Ranking should not be null")
        assertTrue(ranking.isNotEmpty(), "Expected some ranked players")
    }

    @Test
    fun `should return club ranking for global`() = runTest {
        // GIVEN
        val countryCode = "global"

        // WHEN
        val result = client.getClubRanking(countryCode = countryCode)

        // THEN
        assertTrue(result.isSuccess, "Expected success for club ranking in $countryCode")
        val ranking = result.getOrThrow()
        assertNotNull(ranking, "Club ranking must not be null")
        assertTrue(ranking.isNotEmpty(), "Expected some ranked clubs")
    }

    @Test
    fun `should return upcoming events`() = runTest {
        // GIVEN
        // no params

        // WHEN
        val result = client.getEventsRotation()

        // THEN
        assertTrue(result.isSuccess, "Expected success fetching events")
        val events = result.getOrThrow()
        assertNotNull(events, "Events list must not be null")
        assertTrue(events.isNotEmpty(), "Expected at least one active/upcoming event")
    }
}