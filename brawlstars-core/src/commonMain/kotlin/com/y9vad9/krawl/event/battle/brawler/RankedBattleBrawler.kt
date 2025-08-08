package com.y9vad9.krawl.event.battle.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawler.BrawlerName
import com.y9vad9.krawl.brawler.BrawlerPowerLevel
import com.y9vad9.krawl.event.RankedStage

/**
 * A brawler used in a Ranked match.
 *
 * Includes the player's current [RankedStage] at the time of the match.
 *
 * @property id The unique identifier of the brawler.
 * @property name The display name of the brawler.
 * @property powerLevel The power level of the brawler during the match.
 * @property rankedStage The ranked progression stage for this brawler at the time of the match.
 */
public data class RankedBattleBrawler(
    override val id: BrawlerId,
    override val name: BrawlerName,
    override val powerLevel: BrawlerPowerLevel,
    public val rankedStage: RankedStage,
) : BattleBrawler
