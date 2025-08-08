package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.battle.RankedMatchmakingType.DUO
import com.y9vad9.krawl.event.battle.RankedMatchmakingType.SOLO
import com.y9vad9.krawl.event.battle.RankedMatchmakingType.TRIO

/**
 * Represents the matchmaking type used in a ranked battle.
 *
 * This defines how many players were in the lobby at the moment the game was queued.
 */
public enum class RankedMatchmakingType {
    /**
     * One player queued alone; often seen in solo Power League.
     */
    SOLO,

    /**
     * Two players queued together; often used in duo ladder matches or duo Power League.
     */
    DUO,

    /**
     * A full team of three players queued together; common in competitive play.
     */
    TRIO,
}

/**
 * Returns `true` if the matchmaking type was [RankedMatchmakingType.SOLO],
 * meaning the player queued alone.
 */
public val RankedMatchmakingType.isSolo: Boolean
    get() = this == SOLO

/**
 * Returns `true` if the matchmaking type was [RankedMatchmakingType.DUO],
 * meaning two players queued together in the same team.
 */
public val RankedMatchmakingType.isDuo: Boolean
    get() = this == DUO

/**
 * Returns `true` if the matchmaking type was [RankedMatchmakingType.TRIO],
 * meaning a full three-player team queued together.
 */
public val RankedMatchmakingType.isTrio: Boolean
    get() = this == TRIO
