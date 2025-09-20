package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapEnvironmentId
import com.y9vad9.krawl.brawlify.event.map.isAirHockey
import com.y9vad9.krawl.brawlify.event.map.isAnyCoinFactory
import com.y9vad9.krawl.brawlify.event.map.isAnyKatanaKingdom
import com.y9vad9.krawl.brawlify.event.map.isAnyStuntShow
import com.y9vad9.krawl.brawlify.event.map.isArcadesShowdown
import com.y9vad9.krawl.brawlify.event.map.isBazaarisIslandsShowdown
import com.y9vad9.krawl.brawlify.event.map.isBrawlBallArena
import com.y9vad9.krawl.brawlify.event.map.isCoinFactory
import com.y9vad9.krawl.brawlify.event.map.isCoinFactoryBrawlbBall
import com.y9vad9.krawl.brawlify.event.map.isDefault
import com.y9vad9.krawl.brawlify.event.map.isDefaultShowdown
import com.y9vad9.krawl.brawlify.event.map.isEnchantedForest
import com.y9vad9.krawl.brawlify.event.map.isGrassfield
import com.y9vad9.krawl.brawlify.event.map.isGrassfieldBeachBall
import com.y9vad9.krawl.brawlify.event.map.isHockeyIslands
import com.y9vad9.krawl.brawlify.event.map.isHub
import com.y9vad9.krawl.brawlify.event.map.isIslandsShowdown
import com.y9vad9.krawl.brawlify.event.map.isKatanaKingdom
import com.y9vad9.krawl.brawlify.event.map.isKatanaKingdomIslandsShowdown
import com.y9vad9.krawl.brawlify.event.map.isKatanaKingdomShowdown
import com.y9vad9.krawl.brawlify.event.map.isLoveswamp
import com.y9vad9.krawl.brawlify.event.map.isMine
import com.y9vad9.krawl.brawlify.event.map.isMineTrainTracks
import com.y9vad9.krawl.brawlify.event.map.isMortuaryVolley
import com.y9vad9.krawl.brawlify.event.map.isRooftop
import com.y9vad9.krawl.brawlify.event.map.isScrapyard
import com.y9vad9.krawl.brawlify.event.map.isStuntShow
import com.y9vad9.krawl.brawlify.event.map.isStuntShowBrawlBall
import com.y9vad9.krawl.brawlify.event.map.isStuntShowVolley
import com.y9vad9.krawl.brawlify.event.map.isTropicalIslandsBrawlBall
import com.y9vad9.krawl.brawlify.event.map.isTropicallIslandsShowdown
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BrawlifyMapEnvironmentIdTest {

    @Test
    fun `constants have correct rawInt values`() {
        // GIVEN / THEN
        assertEquals(1, BrawlifyMapEnvironmentId.DEFAULT.rawInt)
        assertEquals(2, BrawlifyMapEnvironmentId.KATANA_KINGDOM.rawInt)
        assertEquals(3, BrawlifyMapEnvironmentId.MINE.rawInt)
        assertEquals(4, BrawlifyMapEnvironmentId.HUB.rawInt)
        assertEquals(5, BrawlifyMapEnvironmentId.ARCADES_SHOWDOWN.rawInt)
        assertEquals(6, BrawlifyMapEnvironmentId.DEFAULT_SHOWDOWN.rawInt)
        assertEquals(7, BrawlifyMapEnvironmentId.GRASSFIELD.rawInt)
        assertEquals(8, BrawlifyMapEnvironmentId.ISLANDS_SHOWDOWN.rawInt)
        assertEquals(9, BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL.rawInt)
        assertEquals(10, BrawlifyMapEnvironmentId.GRASSFIELD_BEACH_BALL.rawInt)
        assertEquals(11, BrawlifyMapEnvironmentId.STUNT_SHOW.rawInt)
        assertEquals(12, BrawlifyMapEnvironmentId.SCRAPYARD.rawInt)
        assertEquals(13, BrawlifyMapEnvironmentId.MINE_TRAIN_TRACKS.rawInt)
        assertEquals(14, BrawlifyMapEnvironmentId.BRAWLBALL_ARENA.rawInt)
        assertEquals(15, BrawlifyMapEnvironmentId.LOVESWAMP.rawInt)
        assertEquals(16, BrawlifyMapEnvironmentId.ENCHANTED_FOREST.rawInt)
        assertEquals(17, BrawlifyMapEnvironmentId.STUNT_SHOW_VOLLEY.rawInt)
        assertEquals(18, BrawlifyMapEnvironmentId.ROOFTOP.rawInt)
        assertEquals(19, BrawlifyMapEnvironmentId.TROPICALL_ISLANDS_SHOWDOWN.rawInt)
        assertEquals(20, BrawlifyMapEnvironmentId.MORTUARY_VOLLEY.rawInt)
        assertEquals(21, BrawlifyMapEnvironmentId.TROPICAL_ISLANDS_BRAWL_BALL.rawInt)
        assertEquals(22, BrawlifyMapEnvironmentId.COIN_FACTORY_BRAWLBALL.rawInt)
        assertEquals(23, BrawlifyMapEnvironmentId.COIN_FACTORY.rawInt)
        assertEquals(24, BrawlifyMapEnvironmentId.BAZAARIS_ISLANDS_SHOWDOWN.rawInt)
        assertEquals(25, BrawlifyMapEnvironmentId.AIR_HOCKEY.rawInt)
        assertEquals(26, BrawlifyMapEnvironmentId.HOCKEY_ISLANDS.rawInt)
        assertEquals(27, BrawlifyMapEnvironmentId.KATANA_KINGDOM_SHOWDOWN.rawInt)
        assertEquals(28, BrawlifyMapEnvironmentId.KATANA_KINGDOM_ISLANDS_SHOWDOWN.rawInt)
    }

    @Test
    fun `isDefault and other individual extensions return correct boolean`() {
        // GIVEN
        val env = BrawlifyMapEnvironmentId.DEFAULT

        // THEN
        assertTrue(env.isDefault)
        assertFalse(env.isKatanaKingdom)
        assertFalse(env.isMine)
        assertFalse(env.isHub)
    }

    @Test
    fun `themed group extensions isAnyKatanaKingdom, isAnyStuntShow, isAnyCoinFactory`() {
        // GIVEN / THEN

        // Katana Kingdom group
        assertTrue(BrawlifyMapEnvironmentId.KATANA_KINGDOM.isAnyKatanaKingdom)
        assertTrue(BrawlifyMapEnvironmentId.KATANA_KINGDOM_SHOWDOWN.isAnyKatanaKingdom)
        assertTrue(BrawlifyMapEnvironmentId.KATANA_KINGDOM_ISLANDS_SHOWDOWN.isAnyKatanaKingdom)
        assertFalse(BrawlifyMapEnvironmentId.STUNT_SHOW.isAnyKatanaKingdom)

        // Stunt Show group
        assertTrue(BrawlifyMapEnvironmentId.STUNT_SHOW.isAnyStuntShow)
        assertTrue(BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL.isAnyStuntShow)
        assertTrue(BrawlifyMapEnvironmentId.STUNT_SHOW_VOLLEY.isAnyStuntShow)
        assertFalse(BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL.isAnyKatanaKingdom)

        // Coin Factory group
        assertTrue(BrawlifyMapEnvironmentId.COIN_FACTORY.isAnyCoinFactory)
        assertTrue(BrawlifyMapEnvironmentId.COIN_FACTORY_BRAWLBALL.isAnyCoinFactory)
        assertFalse(BrawlifyMapEnvironmentId.COIN_FACTORY.isAnyStuntShow)
    }

    @Test
    fun `all individual is extensions return true only for correct constant`() {
        // GIVEN
        val mapping = mapOf(
            BrawlifyMapEnvironmentId.DEFAULT to BrawlifyMapEnvironmentId::isDefault,
            BrawlifyMapEnvironmentId.KATANA_KINGDOM to BrawlifyMapEnvironmentId::isKatanaKingdom,
            BrawlifyMapEnvironmentId.MINE to BrawlifyMapEnvironmentId::isMine,
            BrawlifyMapEnvironmentId.HUB to BrawlifyMapEnvironmentId::isHub,
            BrawlifyMapEnvironmentId.ARCADES_SHOWDOWN to BrawlifyMapEnvironmentId::isArcadesShowdown,
            BrawlifyMapEnvironmentId.DEFAULT_SHOWDOWN to BrawlifyMapEnvironmentId::isDefaultShowdown,
            BrawlifyMapEnvironmentId.GRASSFIELD to BrawlifyMapEnvironmentId::isGrassfield,
            BrawlifyMapEnvironmentId.ISLANDS_SHOWDOWN to BrawlifyMapEnvironmentId::isIslandsShowdown,
            BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL to BrawlifyMapEnvironmentId::isStuntShowBrawlBall,
            BrawlifyMapEnvironmentId.GRASSFIELD_BEACH_BALL to BrawlifyMapEnvironmentId::isGrassfieldBeachBall,
            BrawlifyMapEnvironmentId.STUNT_SHOW to BrawlifyMapEnvironmentId::isStuntShow,
            BrawlifyMapEnvironmentId.SCRAPYARD to BrawlifyMapEnvironmentId::isScrapyard,
            BrawlifyMapEnvironmentId.MINE_TRAIN_TRACKS to BrawlifyMapEnvironmentId::isMineTrainTracks,
            BrawlifyMapEnvironmentId.BRAWLBALL_ARENA to BrawlifyMapEnvironmentId::isBrawlBallArena,
            BrawlifyMapEnvironmentId.LOVESWAMP to BrawlifyMapEnvironmentId::isLoveswamp,
            BrawlifyMapEnvironmentId.ENCHANTED_FOREST to BrawlifyMapEnvironmentId::isEnchantedForest,
            BrawlifyMapEnvironmentId.STUNT_SHOW_VOLLEY to BrawlifyMapEnvironmentId::isStuntShowVolley,
            BrawlifyMapEnvironmentId.ROOFTOP to BrawlifyMapEnvironmentId::isRooftop,
            BrawlifyMapEnvironmentId.TROPICALL_ISLANDS_SHOWDOWN to BrawlifyMapEnvironmentId::isTropicallIslandsShowdown,
            BrawlifyMapEnvironmentId.MORTUARY_VOLLEY to BrawlifyMapEnvironmentId::isMortuaryVolley,
            BrawlifyMapEnvironmentId.TROPICAL_ISLANDS_BRAWL_BALL to
                BrawlifyMapEnvironmentId::isTropicalIslandsBrawlBall,
            BrawlifyMapEnvironmentId.COIN_FACTORY_BRAWLBALL to BrawlifyMapEnvironmentId::isCoinFactoryBrawlbBall,
            BrawlifyMapEnvironmentId.COIN_FACTORY to BrawlifyMapEnvironmentId::isCoinFactory,
            BrawlifyMapEnvironmentId.BAZAARIS_ISLANDS_SHOWDOWN to BrawlifyMapEnvironmentId::isBazaarisIslandsShowdown,
            BrawlifyMapEnvironmentId.AIR_HOCKEY to BrawlifyMapEnvironmentId::isAirHockey,
            BrawlifyMapEnvironmentId.HOCKEY_ISLANDS to BrawlifyMapEnvironmentId::isHockeyIslands,
            BrawlifyMapEnvironmentId.KATANA_KINGDOM_SHOWDOWN to BrawlifyMapEnvironmentId::isKatanaKingdomShowdown,
            BrawlifyMapEnvironmentId.KATANA_KINGDOM_ISLANDS_SHOWDOWN to
                BrawlifyMapEnvironmentId::isKatanaKingdomIslandsShowdown
        )

        // THEN
        mapping.forEach { (constant, prop) ->
            // positive
            assertTrue(prop.call(constant), "$constant should return true for its property")
            // negative: all other constants
            mapping.keys.filter { it != constant }.forEach { other ->
                assertFalse(prop.call(other), "$other should return false for property of $constant")
            }
        }
    }
}
