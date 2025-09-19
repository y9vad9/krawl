package com.y9vad9.krawl.brawlify.icon

import com.y9vad9.krawl.player.PlayerIconId
import kotlin.jvm.JvmInline

/**
 * A wrapper over a map of [PlayerIconId] to [BrawlifyPlayerIcon], providing type-safe access to player icons.
 *
 * @property rawMap The underlying map of icons.
 */
@JvmInline
public value class BrawlifyPlayerIcons(
    public val rawMap: Map<PlayerIconId, BrawlifyPlayerIcon>,
) {
    /** Returns all icons as a list. */
    public fun asList(): List<BrawlifyPlayerIcon> = rawMap.values.toList()

    /** Returns the icon with the given [id], or `null` if not found. */
    public operator fun get(id: PlayerIconId): BrawlifyPlayerIcon? = rawMap[id]

    /** Returns the icon with the given [id], or throws an [IllegalArgumentException] if not found. */
    public fun getOrThrow(id: PlayerIconId): BrawlifyPlayerIcon =
        this[id] ?: error("No icon found with id $id")

    /** Returns a sequence of icons for efficient iteration without creating intermediate collections. */
    public fun asSequence(): Sequence<BrawlifyPlayerIcon> = rawMap.values.asSequence()
}

// List-based extensions
/** Returns all player icons of type [BrawlifyBrawlerPlayerIcon]. */
public fun BrawlifyPlayerIcons.brawlerIcons(): List<BrawlifyBrawlerPlayerIcon> =
    asList().filterIsInstance<BrawlifyBrawlerPlayerIcon>()

/** Returns all player icons of type [BrawlifyTrophyRoadPlayerIcon]. */
public fun BrawlifyPlayerIcons.trophyRoadIcons(): List<BrawlifyTrophyRoadPlayerIcon> =
    asList().filterIsInstance<BrawlifyTrophyRoadPlayerIcon>()

/** Returns all player icons of type [BrawlifyRewardPlayerIcon]. */
public fun BrawlifyPlayerIcons.rewardIcons(): List<BrawlifyRewardPlayerIcon> =
    asList().filterIsInstance<BrawlifyRewardPlayerIcon>()

/** Returns all player icons of type [BrawlifyOfferPlayerIcon]. */
public fun BrawlifyPlayerIcons.offerIcons(): List<BrawlifyOfferPlayerIcon> =
    asList().filterIsInstance<BrawlifyOfferPlayerIcon>()

// Sequence-based extensions
/** Returns a sequence of [BrawlifyBrawlerPlayerIcon] for efficient iteration. */
public fun BrawlifyPlayerIcons.brawlerIconsSequence(): Sequence<BrawlifyBrawlerPlayerIcon> =
    asSequence().filterIsInstance<BrawlifyBrawlerPlayerIcon>()

/** Returns a sequence of [BrawlifyTrophyRoadPlayerIcon] for efficient iteration. */
public fun BrawlifyPlayerIcons.trophyRoadIconsSequence(): Sequence<BrawlifyTrophyRoadPlayerIcon> =
    asSequence().filterIsInstance<BrawlifyTrophyRoadPlayerIcon>()

/** Returns a sequence of [BrawlifyRewardPlayerIcon] for efficient iteration. */
public fun BrawlifyPlayerIcons.rewardIconsSequence(): Sequence<BrawlifyRewardPlayerIcon> =
    asSequence().filterIsInstance<BrawlifyRewardPlayerIcon>()

/** Returns a sequence of [BrawlifyOfferPlayerIcon] for efficient iteration. */
public fun BrawlifyPlayerIcons.offerIconsSequence(): Sequence<BrawlifyOfferPlayerIcon> =
    asSequence().filterIsInstance<BrawlifyOfferPlayerIcon>()
