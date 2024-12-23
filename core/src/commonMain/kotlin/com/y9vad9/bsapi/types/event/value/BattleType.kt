package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

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

        override fun create(value: String): Result<BattleType> {
            return Result.success(BattleType(value))
        }
    }
}

public val BattleType.isForTrophies: Boolean
    get() = this == BattleType.TROPHIES

public val BattleType.isRankedGameMode: Boolean
    get() = this == BattleType.SOLO_RANKED || this == BattleType.DUO_RANKED || this == BattleType.TRIO_RANKED