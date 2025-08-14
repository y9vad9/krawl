package com.y9vad9.krawl.brawlify.event.map.environment

import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeId
import kotlin.jvm.JvmInline

/**
 * Represents a unique environment identifier returned by the Brawlify API for a map.
 *
 * These IDs correspond to map environments and may be reused across different game modes.
 * Do not rely on the name of the constant to infer the associated game mode.
 * See: https://brawlapi.com/#/endpoints/maps
 *
 * @property rawInt Underlying integer representing environment id.
 */
@JvmInline
public value class BrawlifyMapEnvironmentId(
    public val rawInt: Int,
) {
    public companion object {
        /** Default fallback environment. */
        public val DEFAULT: BrawlifyGameModeId = BrawlifyGameModeId(1)

        /** Katana Kingdom environment. */
        public val KATANA_KINGDOM: BrawlifyGameModeId = BrawlifyGameModeId(2)

        /** Mine environment. */
        public val MINE: BrawlifyGameModeId = BrawlifyGameModeId(3)

        /** Hub environment. */
        public val HUB: BrawlifyGameModeId = BrawlifyGameModeId(4)

        /** Arcades Showdown environment. */
        public val ARCADES_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(5)

        /** Default Showdown environment. */
        public val DEFAULT_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(6)

        /** Grassfield environment. */
        public val GRASSFIELD: BrawlifyGameModeId = BrawlifyGameModeId(7)

        /** Islands Showdown environment. */
        public val ISLANDS_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(8)

        /** Stunt Show environment variant for Brawl Ball. */
        public val STUNT_SHOW_BRAWL_BALL: BrawlifyGameModeId = BrawlifyGameModeId(9)

        /** Grassfield variant for Beach Ball. */
        public val GRASSFIELD_BEACH_BALL: BrawlifyGameModeId = BrawlifyGameModeId(10)

        /** Stunt Show general environment. */
        public val STUNT_SHOW: BrawlifyGameModeId = BrawlifyGameModeId(11)

        /** Scrapyard environment. */
        public val SCRAPYARD: BrawlifyGameModeId = BrawlifyGameModeId(12)

        /** Mine with train tracks environment. */
        public val MINE_TRAIN_TRACKS: BrawlifyGameModeId = BrawlifyGameModeId(13)

        /** Arena used for Brawl Ball. */
        public val BRAWLBALL_ARENA: BrawlifyGameModeId = BrawlifyGameModeId(14)

        /** Love Swamp environment. */
        public val LOVESWAMP: BrawlifyGameModeId = BrawlifyGameModeId(15)

        /** Enchanted Forest environment. */
        public val ENCHANTED_FOREST: BrawlifyGameModeId = BrawlifyGameModeId(16)

        /** Stunt Show variant for Volley mode. */
        public val STUNT_SHOW_VOLLEY: BrawlifyGameModeId = BrawlifyGameModeId(17)

        /** Rooftop environment. */
        public val ROOFTOP: BrawlifyGameModeId = BrawlifyGameModeId(18)

        /** Tropical Islands environment for Showdown. */
        public val TROPICALL_ISLANDS_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(19)

        /** Mortuary-themed environment for Volley. */
        public val MORTUARY_VOLLEY: BrawlifyGameModeId = BrawlifyGameModeId(20)

        /** Tropical Islands variant for Brawl Ball. */
        public val TROPICAL_ISLANDS_BRAWL_BALL: BrawlifyGameModeId = BrawlifyGameModeId(21)

        /** Coin Factory variant used in Brawl Ball. */
        public val COIN_FACTORY_BRAWLBALL: BrawlifyGameModeId = BrawlifyGameModeId(22)

        /** Coin Factory general environment. */
        public val COIN_FACTORY: BrawlifyGameModeId = BrawlifyGameModeId(23)

        /** Bazaaris Islands Showdown environment. */
        public val BAZAARIS_ISLANDS_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(24)

        /** Air Hockey environment. */
        public val AIR_HOCKEY: BrawlifyGameModeId = BrawlifyGameModeId(25)

        /** Hockey-themed Islands environment. */
        public val HOCKEY_ISLANDS: BrawlifyGameModeId = BrawlifyGameModeId(26)

        /** Katana Kingdom variant for Showdown. */
        public val KATANA_KINGDOM_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(27)

        /** Katana Kingdom + Islands environment for Showdown. */
        public val KATANA_KINGDOM_ISLANDS_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(28)
    }
}

/** Returns true if this environment is Katana Kingdom themed. */
public val BrawlifyGameModeId.isAnyKatanaKingdom: Boolean
    get() = this in listOf(
        BrawlifyMapEnvironmentId.KATANA_KINGDOM,
        BrawlifyMapEnvironmentId.KATANA_KINGDOM_SHOWDOWN,
        BrawlifyMapEnvironmentId.KATANA_KINGDOM_ISLANDS_SHOWDOWN
    )

/** Returns true if this environment is Stunt Show themed. */
public val BrawlifyGameModeId.isAnyStuntShow: Boolean
    get() = this in listOf(
        BrawlifyMapEnvironmentId.STUNT_SHOW,
        BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL,
        BrawlifyMapEnvironmentId.STUNT_SHOW_VOLLEY
    )

/** Returns true if this environment is Coin Factory themed. */
public val BrawlifyGameModeId.isAnyCoinFactory: Boolean
    get() = this in listOf(
        BrawlifyMapEnvironmentId.COIN_FACTORY,
        BrawlifyMapEnvironmentId.COIN_FACTORY_BRAWLBALL
    )

/**
 * Returns `true` if this environment is the default environment.
 */
public val BrawlifyGameModeId.isDefault: Boolean
    get() = this == BrawlifyMapEnvironmentId.DEFAULT

/**
 * Returns `true` if this environment is the Katana Kingdom.
 */
public val BrawlifyGameModeId.isKatanaKingdom: Boolean
    get() = this == BrawlifyMapEnvironmentId.KATANA_KINGDOM

/**
 * Returns `true` if this environment is the Mine.
 */
public val BrawlifyGameModeId.isMine: Boolean
    get() = this == BrawlifyMapEnvironmentId.MINE

/**
 * Returns `true` if this environment is the Hub.
 */
public val BrawlifyGameModeId.isHub: Boolean
    get() = this == BrawlifyMapEnvironmentId.HUB

/**
 * Returns `true` if this environment is Arcades Showdown.
 */
public val BrawlifyGameModeId.isArcadesShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.ARCADES_SHOWDOWN

/**
 * Returns `true` if this environment is Default Showdown.
 */
public val BrawlifyGameModeId.isDefaultShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.DEFAULT_SHOWDOWN

/**
 * Returns `true` if this environment is Grassfield.
 */
public val BrawlifyGameModeId.isGrassfield: Boolean
    get() = this == BrawlifyMapEnvironmentId.GRASSFIELD

/**
 * Returns `true` if this environment is Islands Showdown.
 */
public val BrawlifyGameModeId.isIslandsShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.ISLANDS_SHOWDOWN

/**
 * Returns `true` if this environment is Stunt Show Brawl Ball.
 */
public val BrawlifyGameModeId.isStuntShowBrawlBall: Boolean
    get() = this == BrawlifyMapEnvironmentId.STUNT_SHOW_BRAWL_BALL

/**
 * Returns `true` if this environment is Grassfield Beach Ball.
 */
public val BrawlifyGameModeId.isGrassfieldBeachBall: Boolean
    get() = this == BrawlifyMapEnvironmentId.GRASSFIELD_BEACH_BALL

/**
 * Returns `true` if this environment is Stunt Show.
 */
public val BrawlifyGameModeId.isStuntShow: Boolean
    get() = this == BrawlifyMapEnvironmentId.STUNT_SHOW

/**
 * Returns `true` if this environment is Scrapyard.
 */
public val BrawlifyGameModeId.isScrapyard: Boolean
    get() = this == BrawlifyMapEnvironmentId.SCRAPYARD

/**
 * Returns `true` if this environment is Mine Train Tracks.
 */
public val BrawlifyGameModeId.isMineTrainTracks: Boolean
    get() = this == BrawlifyMapEnvironmentId.MINE_TRAIN_TRACKS

/**
 * Returns `true` if this environment is BrawlbBall Arena.
 */
public val BrawlifyGameModeId.isBrawlbBallArena: Boolean
    get() = this == BrawlifyMapEnvironmentId.BRAWLBALL_ARENA

/**
 * Returns `true` if this environment is Loveswamp.
 */
public val BrawlifyGameModeId.isLoveswamp: Boolean
    get() = this == BrawlifyMapEnvironmentId.LOVESWAMP

/**
 * Returns `true` if this environment is Enchanted Forest.
 */
public val BrawlifyGameModeId.isEnchantedForest: Boolean
    get() = this == BrawlifyMapEnvironmentId.ENCHANTED_FOREST

/**
 * Returns `true` if this environment is Stunt Show Volley.
 */
public val BrawlifyGameModeId.isStuntShowVolley: Boolean
    get() = this == BrawlifyMapEnvironmentId.STUNT_SHOW_VOLLEY

/**
 * Returns `true` if this environment is Rooftop.
 */
public val BrawlifyGameModeId.isRooftop: Boolean
    get() = this == BrawlifyMapEnvironmentId.ROOFTOP

/**
 * Returns `true` if this environment is Tropicall Islands Showdown.
 */
public val BrawlifyGameModeId.isTropicallIslandsShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.TROPICALL_ISLANDS_SHOWDOWN

/**
 * Returns `true` if this environment is Mortuary Volley.
 */
public val BrawlifyGameModeId.isMortuaryVolley: Boolean
    get() = this == BrawlifyMapEnvironmentId.MORTUARY_VOLLEY

/**
 * Returns `true` if this environment is Tropicall Islands Brawl Ball.
 */
public val BrawlifyGameModeId.isTropicalIslandsBrawlBall: Boolean
    get() = this == BrawlifyMapEnvironmentId.TROPICAL_ISLANDS_BRAWL_BALL

/**
 * Returns `true` if this environment is Coin Factory BrawlbBall.
 */
public val BrawlifyGameModeId.isCoinFactoryBrawlbBall: Boolean
    get() = this == BrawlifyMapEnvironmentId.COIN_FACTORY_BRAWLBALL

/**
 * Returns `true` if this environment is Coin Factory.
 */
public val BrawlifyGameModeId.isCoinFactory: Boolean
    get() = this == BrawlifyMapEnvironmentId.COIN_FACTORY

/**
 * Returns `true` if this environment is Bazaaris Islands Showdown.
 */
public val BrawlifyGameModeId.isBazaarisIslandsShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.BAZAARIS_ISLANDS_SHOWDOWN

/**
 * Returns `true` if this environment is Air Hockey.
 */
public val BrawlifyGameModeId.isAirHockey: Boolean
    get() = this == BrawlifyMapEnvironmentId.AIR_HOCKEY

/**
 * Returns `true` if this environment is Hockey Islands.
 */
public val BrawlifyGameModeId.isHockeyIslands: Boolean
    get() = this == BrawlifyMapEnvironmentId.HOCKEY_ISLANDS

/**
 * Returns `true` if this environment is Katana Kingdom Showdown.
 */
public val BrawlifyGameModeId.isKatanaKingdomShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.KATANA_KINGDOM_SHOWDOWN

/**
 * Returns `true` if this environment is Katana Kingdom Islands Showdown.
 */
public val BrawlifyGameModeId.isKatanaKingdomIslandsShowdown: Boolean
    get() = this == BrawlifyMapEnvironmentId.KATANA_KINGDOM_ISLANDS_SHOWDOWN
