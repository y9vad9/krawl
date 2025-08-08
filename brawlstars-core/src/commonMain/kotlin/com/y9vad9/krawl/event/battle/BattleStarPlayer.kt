package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.battle.brawler.BattleBrawler
import com.y9vad9.krawl.event.battle.brawler.FriendlyBattleBrawler
import com.y9vad9.krawl.event.battle.brawler.RankedBattleBrawler
import com.y9vad9.krawl.event.battle.brawler.TrophyLeagueBattleBrawler
import com.y9vad9.krawl.player.PlayerName
import com.y9vad9.krawl.player.PlayerTag
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents the player who earned the Battle Star in a Brawl Stars match.
 *
 * The Battle Star is typically awarded to the most valuable player (MVP) in certain match types.
 */
public sealed interface BattleStarPlayer {
    /**
     * The unique tag of the player (e.g., `#ABC123`).
     */
    public val tag: PlayerTag

    /**
     * The name of the player as shown in-game.
     */
    public val name: PlayerName

    /**
     * The brawler the player used in this battle.
     */
    public val brawler: BattleBrawler
}

/**
 * A Battle Star player in a Friendly battle context.
 */
public data class FriendlyBattleStarPlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawler: FriendlyBattleBrawler,
) : BattleStarPlayer

/**
 * A Battle Star player in a Trophy League battle context.
 */
public data class TrophyLeagueBattleStarPlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawler: TrophyLeagueBattleBrawler,
) : BattleStarPlayer

/**
 * A Battle Star player in a Ranked battle context (e.g., Power League or Club League).
 */
public data class RankedBattleStarPlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawler: RankedBattleBrawler,
) : BattleStarPlayer

/**
 * Returns `true` if this [BattleStarPlayer] is from a Friendly battle.
 * Supports smart casting to [FriendlyBattleStarPlayer].
 */
@OptIn(ExperimentalContracts::class)
public fun BattleStarPlayer.isFriendlyBattle(): Boolean {
    contract {
        returns(true) implies (this@isFriendlyBattle is FriendlyBattleStarPlayer)
    }
    return this is FriendlyBattleStarPlayer
}

/**
 * Returns `true` if this [BattleStarPlayer] is from a Trophy League battle.
 * Supports smart casting to [TrophyLeagueBattleStarPlayer].
 */
@OptIn(ExperimentalContracts::class)
public fun BattleStarPlayer.isTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isTrophyLeague is TrophyLeagueBattleStarPlayer)
    }
    return this is TrophyLeagueBattleStarPlayer
}

/**
 * Returns `true` if this [BattleStarPlayer] is from a Ranked battle (Power/Club League).
 * Supports smart casting to [RankedBattleStarPlayer].
 */
@OptIn(ExperimentalContracts::class)
public fun BattleStarPlayer.isRankedBattle(): Boolean {
    contract {
        returns(true) implies (this@isRankedBattle is RankedBattleStarPlayer)
    }
    return this is RankedBattleStarPlayer
}
