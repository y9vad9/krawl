package com.y9vad9.krawl.brawlify.event.gamemode


/**
 * Represents a unique identifier for a game mode in Brawlify.
 *
 * @property rawInt The raw integer value used to identify the game mode.
 */
@JvmInline
public value class BrawlifyGameModeId(
    public val rawInt: Int,
) {
    public companion object {
        /** 3v3 mode where teams earn stars by defeating opponents. */
        public val BOUNTY: BrawlifyGameModeId = BrawlifyGameModeId(1)

        /** 3v3 mode where teams collect and control gems in the center. */
        public val GEMGRAB: BrawlifyGameModeId = BrawlifyGameModeId(2)

        /** Free-for-all survival mode. */
        public val SOLO_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(3)

        /** Duo version of Showdown with two-player teams. */
        public val DUO_SHOWDOWN: BrawlifyGameModeId = BrawlifyGameModeId(4)

        /** 3v3 mode where teams attack and defend safes. */
        public val HEIST: BrawlifyGameModeId = BrawlifyGameModeId(5)

        /** Event mode where players fight a player-controlled boss. */
        public val BIG_GAME: BrawlifyGameModeId = BrawlifyGameModeId(6)

        /** 3v3 soccer-like mode where teams try to score goals. */
        public val BRAWL_BALL: BrawlifyGameModeId = BrawlifyGameModeId(7)

        /** PvE mode where players defend against waves of robots. */
        public val ROBO_RUMBLE: BrawlifyGameModeId = BrawlifyGameModeId(8)

        /** PvE boss fight mode with a massive AI opponent. */
        public val BOSS_FIGHT: BrawlifyGameModeId = BrawlifyGameModeId(9)

        /** Solo damage race against a big boss. */
        public val TAKEDOWN: BrawlifyGameModeId = BrawlifyGameModeId(12)

        /** Solo kill-based mode. */
        public val LONE_STAR: BrawlifyGameModeId = BrawlifyGameModeId(13)

        /** 3v3 mode where teams try to steal and hold a trophy. */
        public val TROPHY_THIEVES: BrawlifyGameModeId = BrawlifyGameModeId(14)

        /** 3v3 mode where teams capture and hold zones. */
        public val HOT_ZONE: BrawlifyGameModeId = BrawlifyGameModeId(15)

        /** PvE mode where players defend a city from a monster. */
        public val SUPERCITY_RUMPAGE: BrawlifyGameModeId = BrawlifyGameModeId(16)

        /** Round-based 3v3 mode with no respawns mid-round. */
        public val KNOCK_OUT: BrawlifyGameModeId = BrawlifyGameModeId(17)

        /** Basketball-style 3v3 mode. */
        public val BASKETBALL: BrawlifyGameModeId = BrawlifyGameModeId(19)

        /** Volleyball-style 3v3 mode. */
        public val VOLLEYBRAWL: BrawlifyGameModeId = BrawlifyGameModeId(20)

        /** 1v1 dueling mode. */
        public val DUELS: BrawlifyGameModeId = BrawlifyGameModeId(21)

        /** 3v3 elimination-based mode. */
        public val WIPE_OUT: BrawlifyGameModeId = BrawlifyGameModeId(22)

        /** Payload escort 3v3 mode. */
        public val PAYLOAD: BrawlifyGameModeId = BrawlifyGameModeId(23)

        /** Survival/elimination-based mode with dynamic players. */
        public val HUNTERS: BrawlifyGameModeId = BrawlifyGameModeId(25)

        /** Defense-based event mode where a player defends until the end. */
        public val LAST_STAND: BrawlifyGameModeId = BrawlifyGameModeId(26)
    }
}

/** Returns `true` if this ID represents the Bounty mode. */
public val BrawlifyGameModeId.isBounty: Boolean
    get() = this == BrawlifyGameModeId.BOUNTY

/** Returns `true` if this ID represents the Gem Grab mode. */
public val BrawlifyGameModeId.isGemGrab: Boolean
    get() = this == BrawlifyGameModeId.GEMGRAB

/** Returns `true` if this ID represents the Solo Showdown mode. */
public val BrawlifyGameModeId.isSoloShowdown: Boolean
    get() = this == BrawlifyGameModeId.SOLO_SHOWDOWN

/** Returns `true` if this ID represents the Duo Showdown mode. */
public val BrawlifyGameModeId.isDuoShowdown: Boolean
    get() = this == BrawlifyGameModeId.DUO_SHOWDOWN

/** Returns `true` if this ID represents the Heist mode. */
public val BrawlifyGameModeId.isHeist: Boolean
    get() = this == BrawlifyGameModeId.HEIST

/** Returns `true` if this ID represents the Big Game event mode. */
public val BrawlifyGameModeId.isBigGame: Boolean
    get() = this == BrawlifyGameModeId.BIG_GAME

/** Returns `true` if this ID represents the Brawl Ball mode. */
public val BrawlifyGameModeId.isBrawlBall: Boolean
    get() = this == BrawlifyGameModeId.BRAWL_BALL

/** Returns `true` if this ID represents the Robo Rumble event mode. */
public val BrawlifyGameModeId.isRoboRumble: Boolean
    get() = this == BrawlifyGameModeId.ROBO_RUMBLE

/** Returns `true` if this ID represents the Boss Fight event mode. */
public val BrawlifyGameModeId.isBossFight: Boolean
    get() = this == BrawlifyGameModeId.BOSS_FIGHT

/** Returns `true` if this ID represents the Takedown event mode. */
public val BrawlifyGameModeId.isTakedown: Boolean
    get() = this == BrawlifyGameModeId.TAKEDOWN

/** Returns `true` if this ID represents the Lone Star mode. */
public val BrawlifyGameModeId.isLoneStar: Boolean
    get() = this == BrawlifyGameModeId.LONE_STAR

/** Returns `true` if this ID represents the Trophy Thieves event mode. */
public val BrawlifyGameModeId.isTrophyThieves: Boolean
    get() = this == BrawlifyGameModeId.TROPHY_THIEVES

/** Returns `true` if this ID represents the Hot Zone mode. */
public val BrawlifyGameModeId.isHotZone: Boolean
    get() = this == BrawlifyGameModeId.HOT_ZONE

/** Returns `true` if this ID represents the Super City Rampage event mode. */
public val BrawlifyGameModeId.isSupercityRampage: Boolean
    get() = this == BrawlifyGameModeId.SUPERCITY_RUMPAGE

/** Returns `true` if this ID represents the Knockout mode. */
public val BrawlifyGameModeId.isKnockOut: Boolean
    get() = this == BrawlifyGameModeId.KNOCK_OUT

/** Returns `true` if this ID represents the Basketball (Basket Brawl) mode. */
public val BrawlifyGameModeId.isBasketball: Boolean
    get() = this == BrawlifyGameModeId.BASKETBALL

/** Returns `true` if this ID represents the Volley Brawl mode. */
public val BrawlifyGameModeId.isVolleyBrawl: Boolean
    get() = this == BrawlifyGameModeId.VOLLEYBRAWL

/** Returns `true` if this ID represents the Duels mode. */
public val BrawlifyGameModeId.isDuels: Boolean
    get() = this == BrawlifyGameModeId.DUELS

/** Returns `true` if this ID represents the Wipeout mode. */
public val BrawlifyGameModeId.isWipeOut: Boolean
    get() = this == BrawlifyGameModeId.WIPE_OUT

/** Returns `true` if this ID represents the Payload mode. */
public val BrawlifyGameModeId.isPayload: Boolean
    get() = this == BrawlifyGameModeId.PAYLOAD

/** Returns `true` if this ID represents the Hunters mode. */
public val BrawlifyGameModeId.isHunters: Boolean
    get() = this == BrawlifyGameModeId.HUNTERS

/** Returns `true` if this ID represents the Last Stand event mode. */
public val BrawlifyGameModeId.isLastStand: Boolean
    get() = this == BrawlifyGameModeId.LAST_STAND
