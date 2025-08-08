package com.y9vad9.krawl.event.battle.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawler.BrawlerName
import com.y9vad9.krawl.brawler.BrawlerPowerLevel
import com.y9vad9.krawl.event.Trophies

/**
 * A brawler used in a Trophy League match.
 *
 * Includes trophy count at the time of the match, in addition to basic battle properties.
 *
 * @property id The unique identifier of the brawler.
 * @property name The name of the brawler.
 * @property powerLevel The power level of the brawler.
 * @property trophies The number of trophies the brawler had before the match.
 */
public data class TrophyLeagueBattleBrawler(
    override val id: BrawlerId,
    override val name: BrawlerName,
    override val powerLevel: BrawlerPowerLevel,
    public val trophies: Trophies,
) : BattleBrawler
