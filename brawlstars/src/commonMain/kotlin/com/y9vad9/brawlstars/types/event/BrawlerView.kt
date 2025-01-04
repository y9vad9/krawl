package com.y9vad9.brawlstars.types.event

import com.y9vad9.brawlstars.types.brawler.value.BrawlerId
import com.y9vad9.brawlstars.types.brawler.value.BrawlerName
import com.y9vad9.brawlstars.types.brawler.value.PowerLevel
import com.y9vad9.brawlstars.types.event.value.RankedStage
import com.y9vad9.brawlstars.types.event.value.Trophies

public sealed interface BrawlerView {
    public val id: BrawlerId
    public val name: BrawlerName
    public val power: PowerLevel
}

public sealed interface TrophiesOrFriendlyBrawlerView : BrawlerView
public sealed interface RankedOrFriendlyBrawlerView : BrawlerView

public data class FriendlyBrawlerView(
    override val id: BrawlerId,
    override val name: BrawlerName,
) : TrophiesOrFriendlyBrawlerView, RankedOrFriendlyBrawlerView {
    override val power: PowerLevel
        get() = PowerLevel.MAX
}

public data class TrophiesBrawlerView(
    override val id: BrawlerId,
    override val name: BrawlerName,
    override val power: PowerLevel,
    val trophies: Trophies = Trophies.ZERO,
) : TrophiesOrFriendlyBrawlerView

public data class RankedBrawlerView(
    override val id: BrawlerId,
    override val name: BrawlerName,
    override val power: PowerLevel,
    val rankedStage: RankedStage,
) : BrawlerView, RankedOrFriendlyBrawlerView