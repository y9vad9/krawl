package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.ranking.RankingPosition

/**
 * Represents a battle that includes ranking or placement information.
 *
 * This interface is for battles where the local player achieves a final rank or position,
 * such as Showdown modes, but is not limited to them.
 */
public sealed interface RankingBattle : Battle {
    /**
     * The final rank achieved by the local player in this battle.
     */
    public val rank: RankingPosition
}
