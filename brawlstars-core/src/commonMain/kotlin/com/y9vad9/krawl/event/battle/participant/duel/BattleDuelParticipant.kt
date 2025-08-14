package com.y9vad9.krawl.event.battle.participant.duel

import com.y9vad9.krawl.event.battle.brawler.BattleBrawler
import com.y9vad9.krawl.event.battle.participant.BattleBot
import com.y9vad9.krawl.event.battle.participant.BattlePlayer
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
public sealed interface BattleDuelParticipant {
    /** The unique player tag identifying this participant. */
    public val tag: PlayerTag

    /** The display name of this participant. */
    public val name: PlayerName

    /** The brawler selected by this participant for the battle. */
    public val brawlers: List<BattleBrawler>
}

/**
 * Returns `true` if this [com.y9vad9.krawl.event.battle.participant.BattleParticipant] is a [com.y9vad9.krawl.event.battle.participant.BattlePlayer].
 *
 * Enables smart casting to [com.y9vad9.krawl.event.battle.participant.BattlePlayer] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleDuelParticipant.isPlayer(): Boolean {
    contract {
        returns(true) implies (this@isPlayer is BattlePlayer)
    }
    return this is BattleDuelPlayer
}

/**
 * Returns `true` if this [com.y9vad9.krawl.event.battle.participant.BattleParticipant] is a [com.y9vad9.krawl.event.battle.participant.BattleBot].
 *
 * Enables smart casting to [com.y9vad9.krawl.event.battle.participant.BattleBot] within the calling scope.
 */
@OptIn(ExperimentalContracts::class)
public fun BattleDuelParticipant.isBot(): Boolean {
    contract {
        returns(true) implies (this@isBot is BattleBot)
    }
    return this is BattleBot
}


