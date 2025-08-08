package com.y9vad9.krawl.event.battle.participant

import com.y9vad9.krawl.event.battle.brawler.FriendlyBattleBrawler
import com.y9vad9.krawl.event.battle.brawler.RankedBattleBrawler
import com.y9vad9.krawl.event.battle.brawler.TrophyLeagueBattleBrawler
import com.y9vad9.krawl.player.PlayerName
import com.y9vad9.krawl.player.PlayerTag
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents a player participating in a Brawl Stars battle.
 *
 * This sealed interface serves as a common abstraction for all types of players involved
 * in different battle modes, such as friendly, ranked, and trophy league battles.
 *
 * All implementations expose basic player identity and selected brawler information.
 *
 * @see FriendlyBattlePlayer
 * @see RankedBattlePlayer
 * @see TrophyLeagueBattlePlayer
 */
public sealed interface BattlePlayer : BattleParticipant

/**
 * Represents a player participating in a
 **[friendly](https://brawlstars.fandom.com/wiki/Friendly_Battles)** battle.
 *
 * Includes player identity and the [brawler] they used in the friendly match.
 *
 * @property tag Unique tag identifying the player.
 * @property name In-game name of the player.
 * @property brawler Brawler used by the player during the friendly battle.
 */
public data class FriendlyBattlePlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawler: FriendlyBattleBrawler,
) : BattlePlayer

/**
 * Represents a player participating in a
 **[ranked](https://brawlstars.fandom.com/wiki/Ranked)** battle.
 *
 * Includes player identity and the [brawler] they used in the ranked match.
 *
 * @property tag Unique tag identifying the player.
 * @property name In-game name of the player.
 * @property brawler Brawler used by the player during the ranked battle.
 */
public data class RankedBattlePlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawler: RankedBattleBrawler,
) : BattlePlayer

/**
 * Represents a player participating in a
 **[trophy league](https://brawlstars.fandom.com/wiki/Trophies)** battle.
 *
 * Includes player identity and the [brawler] they used in the trophy league match.
 *
 * @property tag Unique tag identifying the player.
 * @property name In-game name of the player.
 * @property brawler Brawler used by the player during the trophy league battle.
 */
public data class TrophyLeagueBattlePlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawler: TrophyLeagueBattleBrawler,
) : BattlePlayer

/**
 * Returns `true` if this [BattlePlayer] is a [FriendlyBattlePlayer].
 *
 * Use this to safely smart-cast the instance to [FriendlyBattlePlayer] when true.
 */
@OptIn(ExperimentalContracts::class)
public fun BattlePlayer.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlyBattlePlayer)
    }
    return this is FriendlyBattlePlayer
}

/**
 * Returns `true` if this [BattlePlayer] is a [RankedBattlePlayer].
 *
 * Use this to safely smart-cast the instance to [RankedBattlePlayer] when true.
 */
@OptIn(ExperimentalContracts::class)
public fun BattlePlayer.isRanked(): Boolean {
    contract {
        returns(true) implies (this@isRanked is RankedBattlePlayer)
    }
    return this is RankedBattlePlayer
}

/**
 * Returns `true` if this [BattlePlayer] is a [TrophyLeagueBattlePlayer].
 *
 * Use this to safely smart-cast the instance to [TrophyLeagueBattlePlayer] when true.
 */
@OptIn(ExperimentalContracts::class)
public fun BattlePlayer.isTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isTrophyLeague is TrophyLeagueBattlePlayer)
    }
    return this is TrophyLeagueBattlePlayer
}
