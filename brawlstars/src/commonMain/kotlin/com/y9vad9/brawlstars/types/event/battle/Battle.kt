package com.y9vad9.brawlstars.types.event.battle

import com.y9vad9.brawlstars.internal.InstantInternalSerializer
import com.y9vad9.brawlstars.types.event.BrawlerView
import com.y9vad9.brawlstars.types.event.Event
import com.y9vad9.brawlstars.types.event.isOfficial
import com.y9vad9.brawlstars.types.event.value.Trophies
import com.y9vad9.brawlstars.types.player.value.EntityTag
import com.y9vad9.brawlstars.types.player.value.PlayerName
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@Serializable
public sealed interface Battle {
    @Serializable(with = InstantInternalSerializer::class)
    public val battleTime: Instant
    public val event: Event
    /**
     * Represents a view of a player in the showdown or teams battle.
     *
     * @param TEntityTag The type of entity tag associated with the player.
     */
    @Serializable
    public data class PlayerView<TEntityTag : EntityTag, TBrawlerView : BrawlerView>(
        /**
         * The unique tag identifying the player.
         */
        val tag: TEntityTag,
        /**
         * The name of the player.
         */
        val name: PlayerName,
        /**
         * The player's brawler view, including trophies or friendly mode information.
         */
        val brawler: TBrawlerView,
    )
}

/**
 * Interface-marker for friendly matches
 */
public sealed interface FriendlyBattle : Battle

public sealed interface TrophiesBattle : Battle {
    public val trophyChange: Trophies
}

public val Battle.isMapMaker: Boolean
    get() = !event.isOfficial

@OptIn(ExperimentalContracts::class)
public fun Battle.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlyBattle)
        returns(false) implies (this@isFriendly !is FriendlyBattle)
    }

    return this is FriendlyBattle
}

@OptIn(ExperimentalContracts::class)
public fun Battle.isForTrophies(): Boolean {
    contract {
        returns(true) implies (this@isForTrophies is TrophiesBattle)
        returns(false) implies (this@isForTrophies !is TrophiesBattle)
    }

    return this is TrophiesBattle
}