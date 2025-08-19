package com.y9vad9.krawl.event.battle.participant.duel

import com.y9vad9.krawl.event.battle.brawler.FriendlyBattleBrawler
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
 * @see FriendlyBattleDuelPlayer
 * @see RankedBattleDuelPlayer
 * @see TrophyLeagueBattleDuelPlayer
 */
public sealed interface BattleDuelPlayer : BattleDuelParticipant

/**
 * Represents a player participating in a
 **[friendly](https://brawlstars.fandom.com/wiki/Friendly_Battles)** battle.
 *
 * Includes player identity and the [brawler] they used in the friendly match.
 *
 * @property tag Unique tag identifying the player.
 * @property name In-game name of the player.
 * @property brawlers Brawlers used by the player during the friendly duel battle.
 */
public data class FriendlyBattleDuelPlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawlers: List<FriendlyBattleBrawler>,
) : BattleDuelPlayer

/**
 * Represents a player participating in a
 * [trophy league](https://brawlstars.fandom.com/wiki/Trophies) battle.
 *
 * Includes player identity and the [brawlers] they used in the trophy league match.
 *
 * @property tag Unique tag identifying the player.
 * @property name In-game name of the player.
 * @property brawlers Brawlers used by the player during the trophy league duel battle.
 */
public data class TrophyLeagueBattleDuelPlayer(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawlers: List<TrophyLeagueBattleBrawler>,
) : BattleDuelPlayer

/**
 * Returns `true` if this [BattleDuelPlayer] is a [FriendlyBattleDuelPlayer].
 *
 * Use this to safely smart-cast the instance to [FriendlyBattleDuelPlayer] when true.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleDuelPlayer.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlyBattleDuelPlayer)
    }
    return this is FriendlyBattleDuelPlayer
}

/**
 * Returns `true` if this [BattleDuelPlayer] is a [TrophyLeagueBattleDuelPlayer].
 *
 * Use this to safely smart-cast the instance to [TrophyLeagueBattleDuelPlayer] when true.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleDuelPlayer.isTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isTrophyLeague is TrophyLeagueBattleDuelPlayer)
    }
    return this is TrophyLeagueBattleDuelPlayer
}
