package com.y9vad9.krawl.brawlify.api.v1.brawler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a Brawl Stars brawler with full details as returned by Brawlify.
 *
 * @property id Unique Brawlify ID for the brawler.
 * @property avatarId ID of the player's avatar associated with the brawler.
 * @property name Display name of the brawler (e.g., "Shelly").
 * @property hash Unique hash identifier for the brawler.
 * @property path Internal path identifier for the brawler.
 * @property fankit Fan kit identifier.
 * @property released Whether the brawler has been released.
 * @property version Schema version of the brawler object.
 * @property link URL to Brawlify's detail page for the brawler.
 * @property imageUrl Primary image URL for the brawler.
 * @property imageUrl2 Secondary image URL for borderless representation.
 * @property imageUrl3 Image URL from the fankit.
 * @property classInfo Class information of the brawler.
 * @property rarity Rarity information of the brawler.
 * @property unlock Optional unlock requirement, if any.
 * @property description Plain text description of the brawler.
 * @property descriptionHtml HTML-formatted description of the brawler.
 * @property starPowers List of star powers available for this brawler.
 * @property gadgets List of gadgets available for this brawler.
 * @property videos List of video URLs or references associated with the brawler.
 */
@Serializable
public data class RawBrawlifyBrawler(
    val id: Int,
    val avatarId: Int,
    val name: String,
    val hash: String,
    val path: String,
    val fankit: String,
    val released: Boolean,
    val version: Int,
    val link: String,
    val imageUrl: String,
    val imageUrl2: String,
    val imageUrl3: String,
    @SerialName("class")
    val classInfo: RawBrawlifyBrawlerClass,
    val rarity: RawBrawlifyBrawlerRarity,
    val unlock: String? = null,
    val description: String,
    val descriptionHtml: String,
    val starPowers: List<RawBrawlifyBrawlerStarPower>,
    val gadgets: List<RawBrawlifyBrawlerGadget>,
    val videos: List<String>,
) {
    /**
     * An alias to [imageUrl2].
     */
    public inline val borderlessImageUrl: String get() = imageUrl2

    /**
     * An alias to [imageUrl3].
     */
    public inline val fankitImageUrl: String get() = imageUrl3
}
