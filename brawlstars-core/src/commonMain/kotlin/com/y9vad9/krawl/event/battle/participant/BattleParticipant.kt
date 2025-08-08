package com.y9vad9.krawl.event.battle.participant

import com.y9vad9.krawl.event.battle.brawler.BattleBrawler
import com.y9vad9.krawl.player.PlayerName
import com.y9vad9.krawl.player.PlayerTag
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents a participant in a Brawl Stars battle.
 *
 * A participant can either be a real player or a bot. This interface abstracts over
 * both cases and provides access to shared information such as the player's tag,
 * name, and chosen brawler.
 */
public sealed interface BattleParticipant {
    /** The unique player tag identifying this participant. */
    public val tag: PlayerTag

    /** The display name of this participant. */
    public val name: PlayerName

    /** The brawler selected by this participant for the battle. */
    public val brawler: BattleBrawler
}

/**
 * Returns `true` if this [BattleParticipant] is a [BattlePlayer].
 *
 * Enables smart casting to [BattlePlayer] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleParticipant.isPlayer(): Boolean {
    contract {
        returns(true) implies (this@isPlayer is BattlePlayer)
    }
    return this is BattlePlayer
}

/**
 * Returns `true` if this [BattleParticipant] is a [BattleBot].
 *
 * Enables smart casting to [BattleBot] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleParticipant.isBot(): Boolean {
    contract {
        returns(true) implies (this@isBot is BattleBot)
    }
    return this is BattleBot
}
