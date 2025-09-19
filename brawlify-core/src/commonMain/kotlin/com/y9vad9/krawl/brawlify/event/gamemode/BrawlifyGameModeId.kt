package com.y9vad9.krawl.brawlify.event.gamemode

import kotlin.jvm.JvmInline

/**
 * Represents a unique identifier for a game mode in Brawlify.
 *
 * @property rawInt The raw integer value used to identify the game mode.
 */
@JvmInline
public value class BrawlifyGameModeId private constructor(
    public val rawInt: Int,
) {
    public companion object {
        private const val MIN_VALUE = 48_000_000
        private const val MAX_VALUE = MIN_VALUE + 1_000

        /**
         * Checks whether the given integer is a valid [BrawlifyGameModeId].
         */
        public fun isValid(value: Int): Boolean = value in MIN_VALUE..MAX_VALUE

        /**
         * Attempts to create a [BrawlifyGameModeId] from the given integer.
         *
         * @return a [Result] wrapping the [BrawlifyGameModeId] if valid, or a failure otherwise.
         */
        public fun create(value: Int): Result<BrawlifyGameModeId> =
            if (isValid(value)) Result.success(BrawlifyGameModeId(value))
            else Result.failure(IllegalArgumentException("Invalid BrawlifyGameModeId: $value"))

        /**
         * Attempts to create a [BrawlifyGameModeId] from the given integer.
         *
         * @return the [BrawlifyGameModeId] if valid, or `null` otherwise.
         */
        public fun createOrNull(value: Int): BrawlifyGameModeId? = create(value).getOrNull()

        /**
         * Creates a [BrawlifyGameModeId] from the given integer, or throws if invalid.
         *
         * @throws IllegalArgumentException if the given integer is not a valid game mode id.
         */
        public fun createOrThrow(value: Int): BrawlifyGameModeId =
            create(value).getOrThrow()

        /** Grab 10 gems to win */
        public val GEM_GRAB: BrawlifyGameModeId = BrawlifyGameModeId(48_000_000)

        /** Shoot open the enemy safe */
        public val HEIST: BrawlifyGameModeId = BrawlifyGameModeId(48_000_002)

        /** Defeat Brawlers for stars */
        public val BOUNTY: BrawlifyGameModeId = BrawlifyGameModeId(48_000_003)

        /** Score two goals to win! */
        public val BRAWL_BALL: BrawlifyGameModeId = BrawlifyGameModeId(48_000_005)

        /** Be the sole survivor! */
        public val SOLO_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(48_000_006)

        /** Defeat the BIG BRAWLER! */
        public val BIG_GAME: BrawlifyGameModeId = BrawlifyGameModeId(48_000_007)

        /** Defend the safe! */
        public val ROBO_RUMBLE: BrawlifyGameModeId = BrawlifyGameModeId(48_000_008)

        /** Be the last team alive! */
        public val DUO_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(48_000_009)

        /** Defeat the Boss */
        public val BOSS_FIGHT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_010)

        /** Destroy enemy base */
        public val SPIRIT_WARS: BrawlifyGameModeId = BrawlifyGameModeId(48_000_011)

        /** Damage the Boss as much as you can! */
        public val TAKEDOWN: BrawlifyGameModeId = BrawlifyGameModeId(48_000_014)

        /** Defeat Brawlers for stars */
        public val LONE_STAR: BrawlifyGameModeId = BrawlifyGameModeId(48_000_015)

        /** Grab two Trophies to win */
        public val TROPHY_THIEVES: BrawlifyGameModeId = BrawlifyGameModeId(48_000_016)

        /** Capture all the Hot Zones! */
        public val HOT_ZONE: BrawlifyGameModeId = BrawlifyGameModeId(48_000_017)

        /** Defeat the Boss */
        public val SUPER_CITY_RAMPAGE: BrawlifyGameModeId = BrawlifyGameModeId(48_000_018)

        /** Defeat opposing Brawlers! */
        public val KNOCKOUT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_020)

        /** Hold the present to collect points! */
        public val CARRY_THE_GIFT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_021)

        /** Shoot some hoops! */
        public val BASKET_BRAWL: BrawlifyGameModeId = BrawlifyGameModeId(48_000_022)

        /** Land the ball on the opponent's side! */
        public val VOLLEY_BRAWL: BrawlifyGameModeId = BrawlifyGameModeId(48_000_023)

        /** Defeat all enemy Brawlers! */
        public val DUELS: BrawlifyGameModeId = BrawlifyGameModeId(48_000_024)

        /** Defeat opponents! */
        public val WIPEOUT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_025)

        /** Push the minecart! */
        public val PAYLOAD: BrawlifyGameModeId = BrawlifyGameModeId(48_000_026)

        /** Destroy the robots! */
        public val BOT_DROP: BrawlifyGameModeId = BrawlifyGameModeId(48_000_027)

        /** Defeat opponents! */
        public val HUNTERS: BrawlifyGameModeId = BrawlifyGameModeId(48_000_028)

        /** Defend 8-Bit! */
        public val LAST_STAND: BrawlifyGameModeId = BrawlifyGameModeId(48_000_029)

        /** Defeat opponents! */
        public val WIPEOUT_5V5: BrawlifyGameModeId = BrawlifyGameModeId(48_000_031)

        /** Score two goals to win! */
        public val BRAWL_BALL_5V5: BrawlifyGameModeId = BrawlifyGameModeId(48_000_032)

        /** Grab 10 gems to win */
        public val GEM_GRAB_5V5: BrawlifyGameModeId = BrawlifyGameModeId(48_000_033)

        /** Grab Trophies and escape! */
        public val TROPHY_ESCAPE: BrawlifyGameModeId = BrawlifyGameModeId(48_000_034)

        /** Defeat opposing Brawlers! */
        public val KNOCKOUT_5V5: BrawlifyGameModeId = BrawlifyGameModeId(48_000_035)

        /** Destroy enemy buildings! */
        public val GODZILLA_CITY_SMASH: BrawlifyGameModeId = BrawlifyGameModeId(48_000_036)

        /** Paint the map with your team's color! */
        public val PAINT_BRAWL: BrawlifyGameModeId = BrawlifyGameModeId(48_000_037)

        /** Be the last team alive! */
        public val TRIO_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(48_000_038)

        /** Win with every Brawler */
        public val DRUM_ROLL: BrawlifyGameModeId = BrawlifyGameModeId(48_000_039)

        /** Collect Souls of defeated opponents! */
        public val SOUL_COLLECTOR: BrawlifyGameModeId = BrawlifyGameModeId(48_000_040)

        /** Pick up the Trash! */
        public val CLEANING_DUTY: BrawlifyGameModeId = BrawlifyGameModeId(48_000_041)

        /** Be the sole survivor! */
        public val SOLO_SHOWDOWN_LIMBO: BrawlifyGameModeId = BrawlifyGameModeId(48_000_042)

        /** Defeat opposing Brawlers! */
        public val KNOCKOUT_LIMBO: BrawlifyGameModeId = BrawlifyGameModeId(48_000_043)

        /** Score three goals to win! */
        public val BRAWL_HOCKEY: BrawlifyGameModeId = BrawlifyGameModeId(48_000_045)

        /** Grab 10 gems to win */
        public val GEM_GRAB_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_046)

        /** Push the pizza to the enemy! */
        public val SPECIAL_DELIVERY: BrawlifyGameModeId = BrawlifyGameModeId(48_000_047)

        /** Destroy the enemy base to win! */
        public val BRAWL_ARENA: BrawlifyGameModeId = BrawlifyGameModeId(48_000_048)

        /** Score two goals to win! */
        public val BRAWL_BALL_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_049)

        /** Defeat opposing Brawlers! */
        public val KNOCKOUT_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_050)

        /** Capture all the Hot Zones! */
        public val HOT_ZONE_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_051)

        /** Shoot some hoops! */
        public val BASKET_BRAWL_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_052)

        /** Score three goals to win! */
        public val BRAWL_HOCKEY_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_053)

        /** Push the pizza to the enemy! */
        public val SPECIAL_DELIVERY_2V2: BrawlifyGameModeId = BrawlifyGameModeId(48_000_054)

        /** Deliver tokens to win! */
        public val TOKEN_RUN: BrawlifyGameModeId = BrawlifyGameModeId(48_000_055)

        /** Collect 10 Treasures to win! */
        public val TREASURE_HUNT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_056)

        /** Protect your VIP! */
        public val VIP_HUNT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_058)

        /** Collect Daruma dolls! */
        public val SAMURAI_SMASH: BrawlifyGameModeId = BrawlifyGameModeId(48_000_060)

        /** Defeat Oni Kenji! */
        public val ONI_HUNT: BrawlifyGameModeId = BrawlifyGameModeId(48_000_061)

        /** Hit enemies with the dodgeball! */
        public val DODGEBRAWL: BrawlifyGameModeId = BrawlifyGameModeId(48_000_063)
    }
}

/** Returns `true` if the game mode is [BrawlifyGameModeId.GEM_GRAB] */
public val BrawlifyGameModeId.isGemGrab: Boolean
    get() = this == BrawlifyGameModeId.GEM_GRAB

/** Returns `true` if the game mode is [BrawlifyGameModeId.HEIST] */
public val BrawlifyGameModeId.isHeist: Boolean
    get() = this == BrawlifyGameModeId.HEIST

/** Returns `true` if the game mode is [BrawlifyGameModeId.BOUNTY] */
public val BrawlifyGameModeId.isBounty: Boolean
    get() = this == BrawlifyGameModeId.BOUNTY

/** Returns `true` if the game mode is [BrawlifyGameModeId.BRAWL_BALL] */
public val BrawlifyGameModeId.isBrawlBall: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_BALL

/** Returns `true` if the game mode is [BrawlifyGameModeId.SOLO_SHOWDOWN] */
public val BrawlifyGameModeId.isSoloShowdown: Boolean
    get() = this == BrawlifyGameModeId.SOLO_SHOWDOWN

/** Returns `true` if the game mode is [BrawlifyGameModeId.BIG_GAME] */
public val BrawlifyGameModeId.isBigGame: Boolean
    get() = this == BrawlifyGameModeId.BIG_GAME

/** Returns `true` if the game mode is [BrawlifyGameModeId.ROBO_RUMBLE] */
public val BrawlifyGameModeId.isRoboRumble: Boolean
    get() = this == BrawlifyGameModeId.ROBO_RUMBLE

/** Returns `true` if the game mode is [BrawlifyGameModeId.DUO_SHOWDOWN] */
public val BrawlifyGameModeId.isDuoShowdown: Boolean
    get() = this == BrawlifyGameModeId.DUO_SHOWDOWN

/** Returns `true` if the game mode is [BrawlifyGameModeId.BOSS_FIGHT] */
public val BrawlifyGameModeId.isBossFight: Boolean
    get() = this == BrawlifyGameModeId.BOSS_FIGHT

/** Returns `true` if the game mode is [BrawlifyGameModeId.SPIRIT_WARS] */
public val BrawlifyGameModeId.isSpiritWars: Boolean
    get() = this == BrawlifyGameModeId.SPIRIT_WARS

/** Returns `true` if the game mode is [BrawlifyGameModeId.TAKEDOWN] */
public val BrawlifyGameModeId.isTakedown: Boolean
    get() = this == BrawlifyGameModeId.TAKEDOWN

/** Returns `true` if the game mode is [BrawlifyGameModeId.LONE_STAR] */
public val BrawlifyGameModeId.isLoneStar: Boolean
    get() = this == BrawlifyGameModeId.LONE_STAR

/** Returns `true` if the game mode is [BrawlifyGameModeId.TROPHY_THIEVES] */
public val BrawlifyGameModeId.isTrophyThieves: Boolean
    get() = this == BrawlifyGameModeId.TROPHY_THIEVES

/** Returns `true` if the game mode is [BrawlifyGameModeId.HOT_ZONE] */
public val BrawlifyGameModeId.isHotZone: Boolean
    get() = this == BrawlifyGameModeId.HOT_ZONE

/** Returns `true` if the game mode is [BrawlifyGameModeId.SUPER_CITY_RAMPAGE] */
public val BrawlifyGameModeId.isSuperCityRampage: Boolean
    get() = this == BrawlifyGameModeId.SUPER_CITY_RAMPAGE

/** Returns `true` if the game mode is [BrawlifyGameModeId.KNOCKOUT] */
public val BrawlifyGameModeId.isKnockout: Boolean
    get() = this == BrawlifyGameModeId.KNOCKOUT

/** Returns `true` if the game mode is [BrawlifyGameModeId.CARRY_THE_GIFT] */
public val BrawlifyGameModeId.isCarryTheGift: Boolean
    get() = this == BrawlifyGameModeId.CARRY_THE_GIFT

/** Returns `true` if the game mode is [BrawlifyGameModeId.BASKET_BRAWL] */
public val BrawlifyGameModeId.isBasketBrawl: Boolean
    get() = this == BrawlifyGameModeId.BASKET_BRAWL

/** Returns `true` if the game mode is [BrawlifyGameModeId.VOLLEY_BRAWL] */
public val BrawlifyGameModeId.isVolleyBrawl: Boolean
    get() = this == BrawlifyGameModeId.VOLLEY_BRAWL

/** Returns `true` if the game mode is [BrawlifyGameModeId.DUELS] */
public val BrawlifyGameModeId.isDuels: Boolean
    get() = this == BrawlifyGameModeId.DUELS

/** Returns `true` if the game mode is [BrawlifyGameModeId.WIPEOUT] */
public val BrawlifyGameModeId.isWipeout: Boolean
    get() = this == BrawlifyGameModeId.WIPEOUT

/** Returns `true` if the game mode is [BrawlifyGameModeId.PAYLOAD] */
public val BrawlifyGameModeId.isPayload: Boolean
    get() = this == BrawlifyGameModeId.PAYLOAD

/** Returns `true` if the game mode is [BrawlifyGameModeId.BOT_DROP] */
public val BrawlifyGameModeId.isBotDrop: Boolean
    get() = this == BrawlifyGameModeId.BOT_DROP

/** Returns `true` if the game mode is [BrawlifyGameModeId.HUNTERS] */
public val BrawlifyGameModeId.isHunters: Boolean
    get() = this == BrawlifyGameModeId.HUNTERS

/** Returns `true` if the game mode is [BrawlifyGameModeId.LAST_STAND] */
public val BrawlifyGameModeId.isLastStand: Boolean
    get() = this == BrawlifyGameModeId.LAST_STAND

/** Returns `true` if the game mode is [BrawlifyGameModeId.WIPEOUT_5V5] */
public val BrawlifyGameModeId.isWipeout5v5: Boolean
    get() = this == BrawlifyGameModeId.WIPEOUT_5V5

/** Returns `true` if the game mode is [BrawlifyGameModeId.BRAWL_BALL_5V5] */
public val BrawlifyGameModeId.isBrawlBall5v5: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_BALL_5V5

/** Returns `true` if the game mode is [BrawlifyGameModeId.GEM_GRAB_5V5] */
public val BrawlifyGameModeId.isGemGrab5v5: Boolean
    get() = this == BrawlifyGameModeId.GEM_GRAB_5V5

/** Returns `true` if the game mode is [BrawlifyGameModeId.TROPHY_ESCAPE] */
public val BrawlifyGameModeId.isTrophyEscape: Boolean
    get() = this == BrawlifyGameModeId.TROPHY_ESCAPE

/** Returns `true` if the game mode is [BrawlifyGameModeId.KNOCKOUT_5V5] */
public val BrawlifyGameModeId.isKnockout5v5: Boolean
    get() = this == BrawlifyGameModeId.KNOCKOUT_5V5

/** Returns `true` if the game mode is [BrawlifyGameModeId.GODZILLA_CITY_SMASH] */
public val BrawlifyGameModeId.isGodzillaCitySmash: Boolean
    get() = this == BrawlifyGameModeId.GODZILLA_CITY_SMASH

/** Returns `true` if the game mode is [BrawlifyGameModeId.PAINT_BRAWL] */
public val BrawlifyGameModeId.isPaintBrawl: Boolean
    get() = this == BrawlifyGameModeId.PAINT_BRAWL

/** Returns `true` if the game mode is [BrawlifyGameModeId.TRIO_SHOWDOWN] */
public val BrawlifyGameModeId.isTrioShowdown: Boolean
    get() = this == BrawlifyGameModeId.TRIO_SHOWDOWN

/** Returns `true` if the game mode is [BrawlifyGameModeId.DRUM_ROLL] */
public val BrawlifyGameModeId.isDrumRoll: Boolean
    get() = this == BrawlifyGameModeId.DRUM_ROLL

/** Returns `true` if the game mode is [BrawlifyGameModeId.SOUL_COLLECTOR] */
public val BrawlifyGameModeId.isSoulCollector: Boolean
    get() = this == BrawlifyGameModeId.SOUL_COLLECTOR

/** Returns `true` if the game mode is [BrawlifyGameModeId.CLEANING_DUTY] */
public val BrawlifyGameModeId.isCleaningDuty: Boolean
    get() = this == BrawlifyGameModeId.CLEANING_DUTY

/** Returns `true` if the game mode is [BrawlifyGameModeId.SOLO_SHOWDOWN_LIMBO] */
public val BrawlifyGameModeId.isSoloShowdownLimbo: Boolean
    get() = this == BrawlifyGameModeId.SOLO_SHOWDOWN_LIMBO

/** Returns `true` if the game mode is [BrawlifyGameModeId.KNOCKOUT_LIMBO] */
public val BrawlifyGameModeId.isKnockoutLimbo: Boolean
    get() = this == BrawlifyGameModeId.KNOCKOUT_LIMBO

/** Returns `true` if the game mode is [BrawlifyGameModeId.BRAWL_HOCKEY] */
public val BrawlifyGameModeId.isBrawlHockey: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_HOCKEY

/** Returns `true` if the game mode is [BrawlifyGameModeId.GEM_GRAB_2V2] */
public val BrawlifyGameModeId.isGemGrab2v2: Boolean
    get() = this == BrawlifyGameModeId.GEM_GRAB_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.SPECIAL_DELIVERY] */
public val BrawlifyGameModeId.isSpecialDelivery: Boolean
    get() = this == BrawlifyGameModeId.SPECIAL_DELIVERY

/** Returns `true` if the game mode is [BrawlifyGameModeId.BRAWL_ARENA] */
public val BrawlifyGameModeId.isBrawlArena: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_ARENA

/** Returns `true` if the game mode is [BrawlifyGameModeId.BRAWL_BALL_2V2] */
public val BrawlifyGameModeId.isBrawlBall2v2: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_BALL_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.KNOCKOUT_2V2] */
public val BrawlifyGameModeId.isKnockout2v2: Boolean
    get() = this == BrawlifyGameModeId.KNOCKOUT_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.HOT_ZONE_2V2] */
public val BrawlifyGameModeId.isHotZone2v2: Boolean
    get() = this == BrawlifyGameModeId.HOT_ZONE_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.BASKET_BRAWL_2V2] */
public val BrawlifyGameModeId.isBasketBrawl2v2: Boolean
    get() = this == BrawlifyGameModeId.BASKET_BRAWL_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.BRAWL_HOCKEY_2V2] */
public val BrawlifyGameModeId.isBrawlHockey2v2: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_HOCKEY_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.SPECIAL_DELIVERY_2V2] */
public val BrawlifyGameModeId.isSpecialDelivery2v2: Boolean
    get() = this == BrawlifyGameModeId.SPECIAL_DELIVERY_2V2

/** Returns `true` if the game mode is [BrawlifyGameModeId.TOKEN_RUN] */
public val BrawlifyGameModeId.isTokenRun: Boolean
    get() = this == BrawlifyGameModeId.TOKEN_RUN

/** Returns `true` if the game mode is [BrawlifyGameModeId.TREASURE_HUNT] */
public val BrawlifyGameModeId.isTreasureHunt: Boolean
    get() = this == BrawlifyGameModeId.TREASURE_HUNT

/** Returns `true` if the game mode is [BrawlifyGameModeId.VIP_HUNT] */
public val BrawlifyGameModeId.isVipHunt: Boolean
    get() = this == BrawlifyGameModeId.VIP_HUNT

/** Returns `true` if the game mode is [BrawlifyGameModeId.SAMURAI_SMASH] */
public val BrawlifyGameModeId.isSamuraiSmash: Boolean
    get() = this == BrawlifyGameModeId.SAMURAI_SMASH

/** Returns `true` if the game mode is [BrawlifyGameModeId.ONI_HUNT] */
public val BrawlifyGameModeId.isOniHunt: Boolean
    get() = this == BrawlifyGameModeId.ONI_HUNT

/** Returns `true` if the game mode is [BrawlifyGameModeId.DODGEBRAWL] */
public val BrawlifyGameModeId.isDodgebrawl: Boolean
    get() = this == BrawlifyGameModeId.DODGEBRAWL
