package com.y9vad9.krawl.event.battle.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawler.BrawlerName
import com.y9vad9.krawl.brawler.BrawlerPowerLevel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents a Brawler used in a battle context.
 *
 * This sealed interface abstracts the common properties of a brawler participating
 * in any type of battle: [id], [name], and [powerLevel].
 *
 * Subtypes provide additional data relevant to the specific battle mode:
 * - [TrophyLeagueBattleBrawler]: For standard multiplayer battles with trophies.
 * - [RankedBattleBrawler]: For competitive ranked modes.
 * - [FriendlyBattleBrawler]: For friendly matches without progression.
 */
public sealed interface BattleBrawler {
    /** Unique identifier of the brawler. */
    public val id: BrawlerId

    /** The localized or canonical name of the brawler. */
    public val name: BrawlerName

    /** The brawler's power level at the time of the battle. */
    public val powerLevel: BrawlerPowerLevel
}

/**
 * Returns `true` if this [BattleBrawler] is a [TrophyLeagueBattleBrawler].
 *
 * Enables smart casting to [TrophyLeagueBattleBrawler] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleBrawler.isInTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isInTrophyLeague is TrophyLeagueBattleBrawler)
    }
    return this is TrophyLeagueBattleBrawler
}

/**
 * Returns `true` if this [BattleBrawler] is a [RankedBattleBrawler].
 *
 * Enables smart casting to [RankedBattleBrawler] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleBrawler.isInRanked(): Boolean {
    contract {
        returns(true) implies (this@isInRanked is RankedBattleBrawler)
    }
    return this is RankedBattleBrawler
}

/**
 * Returns `true` if this [BattleBrawler] is a [FriendlyBattleBrawler].
 *
 * Enables smart casting to [FriendlyBattleBrawler] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleBrawler.isInFriendly(): Boolean {
    contract {
        returns(true) implies (this@isInFriendly is FriendlyBattleBrawler)
    }
    return this is FriendlyBattleBrawler
}
