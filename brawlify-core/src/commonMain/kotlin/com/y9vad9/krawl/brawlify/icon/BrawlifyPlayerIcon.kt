@file:OptIn(ExperimentalContracts::class)

package com.y9vad9.krawl.brawlify.icon

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyPlayerIcon
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.event.Trophies
import com.y9vad9.krawl.player.PlayerIconId
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents a player profile icon in Brawl Stars.
 *
 * A [BrawlifyPlayerIcon] is a visual element associated with the player's account. It can
 * originate from different sources, such as brawlers, progression rewards, trophies,
 * or in-game offers. Each subtype specifies additional metadata depending on its origin.
 */
public sealed interface BrawlifyPlayerIcon {
    /** Unique identifier of the player icon. */
    public val id: PlayerIconId

    /** URL pointing to the icon image. */
    public val imageUrl: BrawlifyUrl
}

/**
 * Player icon unlocked by obtaining a specific [brawlerId].
 *
 * Example: unlocking Shelly's or Mortis' unique profile icon.
 */
public data class BrawlifyBrawlerPlayerIcon(
    public override val id: PlayerIconId,
    /** Identifier of the brawler this icon belongs to. */
    public val brawlerId: BrawlerId,
    public override val imageUrl: BrawlifyUrl,
) : BrawlifyPlayerIcon

/**
 * Player icon unlocked by reaching a certain number of [requiredTrophies].
 *
 * Example: progression icons granted along the Trophy Road.
 */
public data class BrawlifyTrophyRoadPlayerIcon(
    public override val id: PlayerIconId,
    /** Minimum number of trophies required to unlock this icon. */
    public val requiredTrophies: Trophies,
    public override val imageUrl: BrawlifyUrl,
) : BrawlifyPlayerIcon

/**
 * Player icon obtained as a reward from events, challenges,
 * or other special achievements not tied to trophies or brawlers.
 */
public data class BrawlifyRewardPlayerIcon(
    public override val id: PlayerIconId,
    public override val imageUrl: BrawlifyUrl,
) : BrawlifyPlayerIcon

/**
 * Player icon obtained through in-game shop offers or bundles.
 */
public data class BrawlifyOfferPlayerIcon(
    public override val id: PlayerIconId,
    public override val imageUrl: BrawlifyUrl,
) : BrawlifyPlayerIcon

/** Returns `true` if this [BrawlifyPlayerIcon] is a [BrawlifyBrawlerPlayerIcon]. */
public fun BrawlifyPlayerIcon.isBrawler(): Boolean {
    contract {
        returns(true) implies (this@isBrawler is BrawlifyBrawlerPlayerIcon)
    }
    return this is BrawlifyBrawlerPlayerIcon
}

/** Returns `true` if this [BrawlifyPlayerIcon] is a [BrawlifyTrophyRoadPlayerIcon]. */
public fun BrawlifyPlayerIcon.isTrophyRoad(): Boolean {
    contract {
        returns(true) implies (this@isTrophyRoad is BrawlifyTrophyRoadPlayerIcon)
    }
    return this is BrawlifyTrophyRoadPlayerIcon
}

/** Returns `true` if this [BrawlifyPlayerIcon] is a [BrawlifyRewardPlayerIcon]. */
public fun BrawlifyPlayerIcon.isReward(): Boolean {
    contract {
        returns(true) implies (this@isReward is BrawlifyRewardPlayerIcon)
    }
    return this is BrawlifyRewardPlayerIcon
}

/** Returns `true` if this [BrawlifyPlayerIcon] is an [BrawlifyOfferPlayerIcon]. */
public fun BrawlifyPlayerIcon.isOffer(): Boolean {
    contract {
        returns(true) implies (this@isOffer is BrawlifyOfferPlayerIcon)
    }
    return this is BrawlifyOfferPlayerIcon
}

/**
 * Converts this [RawBrawlifyPlayerIcon] into a strongly-typed [BrawlifyPlayerIcon].
 *
 * Depending on the data provided by the raw object, one of the specific subtypes is returned:
 * - [BrawlifyBrawlerPlayerIcon] if a `brawler` ID is present
 * - [BrawlifyRewardPlayerIcon] if `isReward` is `true`
 * - [BrawlifyOfferPlayerIcon] if `isAvailableForOffers` is `true`
 *
 * @throws IllegalArgumentException if [PlayerIconId] or [BrawlifyUrl] validation fails
 * @throws IllegalStateException if the raw icon does not match any expected subtype
 */
public fun RawBrawlifyPlayerIcon.toTypedOrThrow(): BrawlifyPlayerIcon {
    val id = PlayerIconId.createOrThrow(id)
    val imageUrl = BrawlifyUrl.createOrThrow(imageUrl)

    return when {
        brawler != null -> BrawlifyBrawlerPlayerIcon(
            id = id,
            brawlerId = BrawlerId.createOrThrow(brawler!!),
            imageUrl = imageUrl,
        )
        isReward -> BrawlifyRewardPlayerIcon(id, imageUrl)
        isAvailableForOffers -> BrawlifyOfferPlayerIcon(id, imageUrl)
        else -> error("Unexpected player icon variance: $this.")
    }
}

/**
 * Converts this [RawBrawlifyPlayerIcon] into a strongly-typed [BrawlifyPlayerIcon], or returns `null`
 * if the conversion fails.
 *
 * This function is a safe alternative to [toTypedOrThrow], catching and suppressing any exceptions
 * that may occur during the conversion process (e.g., invalid IDs, unexpected subtype).
 *
 * @return the corresponding [BrawlifyPlayerIcon], or `null` if the conversion is not possible
 */
public fun RawBrawlifyPlayerIcon.toTypedOrNull(): BrawlifyPlayerIcon? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
