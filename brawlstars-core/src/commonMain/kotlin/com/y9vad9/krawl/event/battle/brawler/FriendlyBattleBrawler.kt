package com.y9vad9.krawl.event.battle.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawler.BrawlerName
import com.y9vad9.krawl.brawler.BrawlerPowerLevel

/**
 * A brawler used in a Friendly battle.
 *
 * In friendly matches, power levels do not affect performance.
 * This type always returns [BrawlerPowerLevel.MAX] regardless of input.
 *
 * @property id The unique identifier of the brawler.
 * @property name The display name of the brawler.
 */
public data class FriendlyBattleBrawler(
    override val id: BrawlerId,
    override val name: BrawlerName,
) : BattleBrawler {

    /**
     * The power level of the brawler. For friendly battles,
     * it's always the maximum available level.
     */
    override val powerLevel: BrawlerPowerLevel
        get() = BrawlerPowerLevel.MAX
}
