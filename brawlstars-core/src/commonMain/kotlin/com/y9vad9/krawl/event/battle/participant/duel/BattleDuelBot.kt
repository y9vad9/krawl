package com.y9vad9.krawl.event.battle.participant.duel

import com.y9vad9.krawl.event.battle.brawler.FriendlyBattleBrawler
import com.y9vad9.krawl.player.PlayerName
import com.y9vad9.krawl.player.PlayerTag

/**
 * A bot that participated in the duel battle.
 *
 * This represents an AI-controlled participant. It occurs only in friendly battles.
 */
public data class BattleDuelBot(
    override val tag: PlayerTag,
    override val name: PlayerName,
    override val brawlers: List<FriendlyBattleBrawler>,
) : BattleDuelParticipant
