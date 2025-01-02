package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.annotations.ContextualBSApi
import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import com.y9vad9.bsapi.types.event.*

@Serializable
@JvmInline
public value class BattleType private constructor(public val value: String) {

    public companion object : ValueConstructor<BattleType, String> {
        /**
         * Note: in API, regular matches for trophies are named as 'ranked'
         * that conflicts with 'RANKED' game mode.
         * I decided to go with [TROPHIES] for better UX.
         *
         * @see isForTrophies
         */
        public val TROPHIES: BattleType = BattleType("ranked")

        /**
         * Solo ranked game representative.
         * @see isRankedGameMode
         */
        public val SOLO_RANKED: BattleType = BattleType("soloRanked")

        /**
         * Duo ranked game representative.
         * @see isRankedGameMode
         */
        public val DUO_RANKED: BattleType = BattleType("duoRanked")

        /**
         * Trio ranked game representative.
         * @see isRankedGameMode
         */
        public val TRIO_RANKED: BattleType = BattleType("trioRanked")

        /**
         * Friendly game representative.
         * @see isFriendly
         */
        public val FRIENDLY: BattleType = BattleType("friendly")

        override fun create(value: String): Result<BattleType> {
            return Result.success(BattleType(value))
        }
    }
}

/**
 * Returns whether battle was for trophies.
 * Sometimes might be not true: for MegaPig and, for example, Mega Tree –
 * it's not a case; it will tell that it's for trophies, but
 * if there's no [RawBattle.BattleResult.trophyChange] – this
 * will be invalid.
 *
 * Better to use [RawBattle.isForTrophies] instead.
 */
@ContextualBSApi
public val BattleType.isForTrophies: Boolean
    get() = this == BattleType.TROPHIES

public val BattleType.isRankedGameMode: Boolean
    get() = this == BattleType.SOLO_RANKED || this == BattleType.DUO_RANKED || this == BattleType.TRIO_RANKED

public val BattleType.isFriendly: Boolean
    get() = this == BattleType.FRIENDLY