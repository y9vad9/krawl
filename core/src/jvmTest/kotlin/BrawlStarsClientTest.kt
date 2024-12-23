@file:OptIn(ValueConstructor.Unsafe::class)

import com.y9vad9.bsapi.BrawlStarsClient
import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import com.y9vad9.bsapi.types.club.value.ClubTag
import com.y9vad9.bsapi.types.common.value.CountryCode
import com.y9vad9.bsapi.types.createUnsafe
import com.y9vad9.bsapi.types.player.value.PlayerTag
import io.ktor.client.engine.java.*
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class BrawlStarsClientIntegrationTest {

    private val testBearerToken = System.getenv("BRAWL_STARS_API_TOKEN") ?: ""
    private val client: BrawlStarsClient = BrawlStarsClient(testBearerToken, engine = Java.create())
    private val testPlayerTag = PlayerTag.createUnsafe("#9V8LCUC0G")
    private val testClubTag = ClubTag.createUnsafe("2YJ2RGGVC")
    private val testBrawlerId = BrawlerId.createUnsafe(16000000)

    @Test
    fun testGetPlayer() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getPlayer(testPlayerTag)
        assertTrue(result.isSuccess, "Expected getPlayer() to succeed.")
        val player = result.getOrNull()
        assertNotNull(player, "Expected a non-null Player object.")
        println("Player name: ${player.name}")
    }

    @Test
    fun testGetPlayerBattlelog() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getPlayerBattlelog(testPlayerTag)
        assertTrue(result.isSuccess, "Expected getPlayerBattlelog() to succeed.")
        val battles = result.getOrNull()
        assertNotNull(battles, "Expected a non-null battle log.")
        println("Retrieved ${battles.size} battles.")
    }

    @Test
    fun testGetClub() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getClub(testClubTag)
        
        assertTrue(result.isSuccess, "Expected getClub() to succeed.")
        val club = result.getOrNull()
        assertNotNull(club, "Expected a non-null Club object.")
        println("Club name: ${club.name}")
    }

    @Test
    fun testGetClubMembers() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getClubMembers(testClubTag)
        
        assertTrue(result.isSuccess, "Expected getClubMembers() to succeed.")
        val members = result.getOrNull()
        assertNotNull(members, "Expected a non-null list of club members.")
        println("Retrieved ${members.size} club members.")
    }

    @Test
    fun testGetBrawlers() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getBrawlers()
        
        assertTrue(result.isSuccess, "Expected getBrawlers() to succeed.")
        val brawlers = result.getOrNull()
        assertNotNull(brawlers, "Expected a non-null list of brawlers.")
        println("Retrieved ${brawlers.size} brawlers.")
    }

    @Test
    fun testGetBrawler() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getBrawler(testBrawlerId)
        
        assertTrue(result.isSuccess, "Expected getBrawler() to succeed.")
        val brawler = result.getOrNull()
        assertNotNull(brawler, "Expected a non-null Brawler object.")
        println("Brawler name: ${brawler.name}")
    }

    @Test
    fun testGetClubsRankings() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getClubsRankings(CountryCode.GLOBAL)
        
        assertTrue(result.isSuccess, "Expected getClubsRankings() to succeed.")
        val rankings = result.getOrNull()
        assertNotNull(rankings, "Expected a non-null list of club rankings.")
        println("Retrieved ${rankings.size} club rankings.")
    }

    @Test
    fun testGetPlayersRankings() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getPlayersRankings(CountryCode.GLOBAL)
        assertTrue(result.isSuccess, "Expected getPlayersRankings() to succeed.")
        val rankings = result.getOrNull()
        assertNotNull(rankings, "Expected a non-null list of player rankings.")
        println("Retrieved ${rankings.size} player rankings.")
    }

    @Test
    fun testGetBrawlerRankings() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getBrawlerRankings(CountryCode.GLOBAL, testBrawlerId)
        assertTrue(result.isSuccess, "Expected getBrawlerRankings() to succeed.")
        val rankings = result.getOrNull()
        assertNotNull(rankings, "Expected a non-null list of brawler rankings.")
        println("Retrieved ${rankings.size} brawler rankings.")
    }

    @Test
    fun testGetEventRotation() = runTest {
        if (testBearerToken.isBlank()) return@runTest

        val result = client.getEventRotation()
        
        assertTrue(result.isSuccess, "Expected getEventRotation() to succeed.")
        val events = result.getOrNull()
        assertNotNull(events, "Expected a non-null list of scheduled events.")
        println("Retrieved ${events.size} scheduled events.")
    }
}
