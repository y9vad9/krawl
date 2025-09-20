package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapEnvironment
import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapEnvironmentId
import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapEnvironmentName
import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapEnvironmentVersion
import com.y9vad9.krawl.brawlify.event.map.isDefault
import com.y9vad9.krawl.brawlify.event.map.isDefaultShowdown
import com.y9vad9.krawl.brawlify.event.map.isHub
import com.y9vad9.krawl.brawlify.event.map.isKatanaKingdom
import com.y9vad9.krawl.brawlify.event.map.isMine
import com.y9vad9.krawl.brawlify.event.map.isRooftop
import com.y9vad9.krawl.brawlify.event.map.isStuntShowVolley
import com.y9vad9.krawl.brawlify.event.map.isGrassfield
import com.y9vad9.krawl.brawlify.event.map.isAirHockey
import com.y9vad9.krawl.brawlify.event.map.isAnyCoinFactory
import com.y9vad9.krawl.brawlify.event.map.isAnyKatanaKingdom
import com.y9vad9.krawl.brawlify.event.map.isAnyStuntShow
import com.y9vad9.krawl.brawlify.event.map.isArcadesShowdown
import com.y9vad9.krawl.brawlify.event.map.isBazaarisIslandsShowdown
import com.y9vad9.krawl.brawlify.event.map.isBrawlBallArena
import com.y9vad9.krawl.brawlify.event.map.isCoinFactory
import com.y9vad9.krawl.brawlify.event.map.isCoinFactoryBrawlbBall
import com.y9vad9.krawl.brawlify.event.map.isEnchantedForest
import com.y9vad9.krawl.brawlify.event.map.isGrassfieldBeachBall
import com.y9vad9.krawl.brawlify.event.map.isHockeyIslands
import com.y9vad9.krawl.brawlify.event.map.isIslandsShowdown
import com.y9vad9.krawl.brawlify.event.map.isKatanaKingdomIslandsShowdown
import com.y9vad9.krawl.brawlify.event.map.isKatanaKingdomShowdown
import com.y9vad9.krawl.brawlify.event.map.isLoveswamp
import com.y9vad9.krawl.brawlify.event.map.isMineTrainTracks
import com.y9vad9.krawl.brawlify.event.map.isMortuaryVolley
import com.y9vad9.krawl.brawlify.event.map.isScrapyard
import com.y9vad9.krawl.brawlify.event.map.isStuntShow
import com.y9vad9.krawl.brawlify.event.map.isStuntShowBrawlBall
import com.y9vad9.krawl.brawlify.event.map.isTropicalIslandsBrawlBall
import com.y9vad9.krawl.brawlify.event.map.isTropicallIslandsShowdown
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BrawlifyMapEnvironmentTest {

    private fun createEnv(id: BrawlifyMapEnvironmentId) = BrawlifyMapEnvironment(
        id = id,
        name = BrawlifyMapEnvironmentName("dummy"),
        pathSegment = BrawlifyPathSegment("dummy"),
        path = BrawlifyPathSegment("dummy"),
        version = BrawlifyMapEnvironmentVersion.FIRST,
        imageUrl = BrawlifyUrl.createOrThrow("https://cdn-misc.brawlify.com/environment/special/Challenge.png")
    )

    @Test
    fun `environment extensions match id extensions`() {
        // GIVEN
        val allEnvironments = listOf(
            BrawlifyMapEnvironmentId.DEFAULT,
            BrawlifyMapEnvironmentId.KATANA_KINGDOM,
            BrawlifyMapEnvironmentId.KATANA_KINGDOM_SHOWDOWN,
            BrawlifyMapEnvironmentId.KATANA_KINGDOM_ISLANDS_SHOWDOWN,
            BrawlifyMapEnvironmentId.MINE,
            BrawlifyMapEnvironmentId.HUB,
            BrawlifyMapEnvironmentId.ARCADES_SHOWDOWN,
            BrawlifyMapEnvironmentId.DEFAULT_SHOWDOWN,
            BrawlifyMapEnvironmentId.GRASSFIELD,
            BrawlifyMapEnvironmentId.ISLANDS_SHOWDOWN,
            BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL,
            BrawlifyMapEnvironmentId.GRASSFIELD_BEACH_BALL,
            BrawlifyMapEnvironmentId.STUNT_SHOW,
            BrawlifyMapEnvironmentId.SCRAPYARD,
            BrawlifyMapEnvironmentId.MINE_TRAIN_TRACKS,
            BrawlifyMapEnvironmentId.BRAWLBALL_ARENA,
            BrawlifyMapEnvironmentId.LOVESWAMP,
            BrawlifyMapEnvironmentId.ENCHANTED_FOREST,
            BrawlifyMapEnvironmentId.STUNT_SHOW_VOLLEY,
            BrawlifyMapEnvironmentId.ROOFTOP,
            BrawlifyMapEnvironmentId.TROPICALL_ISLANDS_SHOWDOWN,
            BrawlifyMapEnvironmentId.MORTUARY_VOLLEY,
            BrawlifyMapEnvironmentId.TROPICAL_ISLANDS_BRAWL_BALL,
            BrawlifyMapEnvironmentId.COIN_FACTORY_BRAWLBALL,
            BrawlifyMapEnvironmentId.COIN_FACTORY,
            BrawlifyMapEnvironmentId.BAZAARIS_ISLANDS_SHOWDOWN,
            BrawlifyMapEnvironmentId.AIR_HOCKEY,
            BrawlifyMapEnvironmentId.HOCKEY_ISLANDS
        )

        allEnvironments.forEach { id ->
            // WHEN
            val env = createEnv(id)

            // THEN - each extension should match id's extension
            assertEquals(id.isDefault, env.isDefault)
            assertEquals(id.isKatanaKingdom, env.isKatanaKingdom)
            assertEquals(id.isMine, env.isMine)
            assertEquals(id.isHub, env.isHub)
            assertEquals(id.isArcadesShowdown, env.isArcadesShowdown)
            assertEquals(id.isDefaultShowdown, env.isDefaultShowdown)
            assertEquals(id.isGrassfield, env.isGrassfield)
            assertEquals(id.isIslandsShowdown, env.isIslandsShowdown)
            assertEquals(id.isStuntShowBrawlBall, env.isStuntShowBrawlBall)
            assertEquals(id.isGrassfieldBeachBall, env.isGrassfieldBeachBall)
            assertEquals(id.isStuntShow, env.isStuntShow)
            assertEquals(id.isScrapyard, env.isScrapyard)
            assertEquals(id.isMineTrainTracks, env.isMineTrainTracks)
            assertEquals(id.isBrawlBallArena, env.isBrawlBallArena)
            assertEquals(id.isLoveswamp, env.isLoveswamp)
            assertEquals(id.isEnchantedForest, env.isEnchantedForest)
            assertEquals(id.isStuntShowVolley, env.isStuntShowVolley)
            assertEquals(id.isRooftop, env.isRooftop)
            assertEquals(id.isTropicallIslandsShowdown, env.isTropicallIslandsShowdown)
            assertEquals(id.isMortuaryVolley, env.isMortuaryVolley)
            assertEquals(id.isTropicalIslandsBrawlBall, env.isTropicalIslandsBrawlBall)
            assertEquals(id.isCoinFactoryBrawlbBall, env.isCoinFactoryBrawlbBall)
            assertEquals(id.isCoinFactory, env.isCoinFactory)
            assertEquals(id.isBazaarisIslandsShowdown, env.isBazaarisIslandsShowdown)
            assertEquals(id.isAirHockey, env.isAirHockey)
            assertEquals(id.isHockeyIslands, env.isHockeyIslands)
            assertEquals(id.isKatanaKingdomShowdown, env.isKatanaKingdomShowdown)
            assertEquals(id.isKatanaKingdomIslandsShowdown, env.isKatanaKingdomIslandsShowdown)

            // grouped checks
            assertEquals(id.isAnyKatanaKingdom, env.isAnyKatanaKingdom)
            assertEquals(id.isAnyStuntShow, env.isAnyStuntShow)
            assertEquals(id.isAnyCoinFactory, env.isAnyCoinFactory)
        }
    }

    @Test
    fun `extensions return false for unrelated id`() {
        // GIVEN
        val unrelatedId = BrawlifyMapEnvironmentId(999)
        val env = createEnv(unrelatedId)

        // THEN
        assertFalse(env.isDefault)
        assertFalse(env.isKatanaKingdom)
        assertFalse(env.isMine)
        assertFalse(env.isHub)
        assertFalse(env.isArcadesShowdown)
        assertFalse(env.isDefaultShowdown)
        assertFalse(env.isGrassfield)
        assertFalse(env.isIslandsShowdown)
        assertFalse(env.isStuntShowBrawlBall)
        assertFalse(env.isGrassfieldBeachBall)
        assertFalse(env.isStuntShow)
        assertFalse(env.isScrapyard)
        assertFalse(env.isMineTrainTracks)
        assertFalse(env.isBrawlBallArena)
        assertFalse(env.isLoveswamp)
        assertFalse(env.isEnchantedForest)
        assertFalse(env.isStuntShowVolley)
        assertFalse(env.isRooftop)
        assertFalse(env.isTropicallIslandsShowdown)
        assertFalse(env.isMortuaryVolley)
        assertFalse(env.isTropicalIslandsBrawlBall)
        assertFalse(env.isCoinFactoryBrawlbBall)
        assertFalse(env.isCoinFactory)
        assertFalse(env.isBazaarisIslandsShowdown)
        assertFalse(env.isAirHockey)
        assertFalse(env.isHockeyIslands)
        assertFalse(env.isKatanaKingdomShowdown)
        assertFalse(env.isKatanaKingdomIslandsShowdown)
        assertFalse(env.isAnyKatanaKingdom)
        assertFalse(env.isAnyStuntShow)
        assertFalse(env.isAnyCoinFactory)
    }
}
