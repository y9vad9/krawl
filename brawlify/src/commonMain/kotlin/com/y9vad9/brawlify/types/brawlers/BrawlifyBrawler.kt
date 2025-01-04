package com.y9vad9.brawlify.types.brawlers

import com.y9vad9.brawlify.types.brawlers.value.BrawlifyBrawlerClassId
import com.y9vad9.brawlify.types.brawlers.value.BrawlifyBrawlerClassName
import com.y9vad9.brawlify.types.brawlers.value.BrawlifyBrawlerRarityId
import com.y9vad9.brawlify.types.brawlers.value.BrawlifyBrawlerRarityName
import com.y9vad9.brawlify.types.events.value.BrawlifyUrl
import com.y9vad9.brawlify.types.value.BrawlifyDescription
import com.y9vad9.brawlify.types.value.BrawlifyDescriptionHtml
import com.y9vad9.brawlify.types.value.BrawlifyHash
import com.y9vad9.brawlify.types.value.BrawlifyVersion
import com.y9vad9.brawlstars.types.brawler.value.*
import com.y9vad9.brawlstars.types.value.HexColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyBrawler(
    val id: BrawlerId,
    val name: BrawlerName,
    val hash: BrawlifyHash,
    val path: BrawlifyHash,
    val fankit: BrawlifyHash,
    val released: Boolean,
    val version: BrawlifyVersion,
    /**
     * The link pointing to the information page on Brawlify.com.
     */
    val link: BrawlifyUrl,
    /**
     * The link pointing to the brawler's 'avatar', that you as a player
     * may choose in the Game for your profile.
     *
     * With borders as in the game.
     */
    @SerialName("imageUrl")
    val profileImageUrl: BrawlifyUrl,
    /**
     * The link pointing to the brawler's 'avatar', that you as a player
     * may choose in the Game for your profile.
     *
     * Without borders.
     */
    @SerialName("imageUrl2")
    val profileImageUrlBorderless: BrawlifyUrl,
    /**
     * The link pointing to the brawler's default 'pin', that you as a player
     * have by default.
     */
    @SerialName("imageUrl3")
    val pinImageUrl: BrawlifyUrl,
    /**
     * Brawler's class.
     */
    @SerialName("class")
    val role: Class,
    val rarity: Rarity,
    val description: BrawlifyDescription,
    val descriptionHtml: BrawlifyDescriptionHtml,
    val starPowers: List<StarPower>,
    val gadgets: List<Gadget>,
) {
    @Serializable
    public data class Class(
        val id: BrawlifyBrawlerClassId,
        val name: BrawlifyBrawlerClassName,
    )

    @Serializable
    public data class Rarity(
        public val id: BrawlifyBrawlerRarityId,
        public val name: BrawlifyBrawlerRarityName,
        public val color: HexColor,
    )

    @Serializable
    public data class StarPower(
        public val id: StarPowerId,
        public val name: StarPowerName,
        public val description: BrawlifyDescription,
        public val descriptionHtml: BrawlifyDescriptionHtml,
        public val imageUrl: BrawlifyUrl,
        public val released: Boolean,
    )

    @Serializable
    public data class Gadget(
        public val id: GadgetId,
        public val name: GadgetName,
        public val description: BrawlifyDescription,
        public val descriptionHtml: BrawlifyDescriptionHtml,
        public val imageUrl: BrawlifyUrl,
        public val released: Boolean,
    )
}

public val BrawlifyBrawler.Class.isDamageDealer: Boolean
    get() = id == BrawlifyBrawlerClassId.DAMAGE_DEALER

public val BrawlifyBrawler.Class.isTank: Boolean
    get() = id == BrawlifyBrawlerClassId.TANK

public val BrawlifyBrawler.Class.isArtillery: Boolean
    get() = id == BrawlifyBrawlerClassId.ARTILLERY

public val BrawlifyBrawler.Class.isMarksman: Boolean
    get() = id == BrawlifyBrawlerClassId.MARKSMAN

public val BrawlifyBrawler.Class.isController: Boolean
    get() = id == BrawlifyBrawlerClassId.CONTROLLER

public val BrawlifyBrawler.Class.isSupport: Boolean
    get() = id == BrawlifyBrawlerClassId.SUPPORT

public val BrawlifyBrawler.`class`: BrawlifyBrawler.Class get() = role

public val BrawlifyBrawler.Rarity.isCommon: Boolean
    get() = id == BrawlifyBrawlerRarityId.COMMON

public val BrawlifyBrawler.Rarity.isRare: Boolean
    get() = id == BrawlifyBrawlerRarityId.RARE

public val BrawlifyBrawler.Rarity.isSuperRare: Boolean
    get() = id == BrawlifyBrawlerRarityId.SUPER_RARE

public val BrawlifyBrawler.Rarity.isEpic: Boolean
    get() = id == BrawlifyBrawlerRarityId.EPIC

public val BrawlifyBrawler.Rarity.isMythic: Boolean
    get() = id == BrawlifyBrawlerRarityId.MYTHIC

public val BrawlifyBrawler.Rarity.isLegendary: Boolean
    get() = id == BrawlifyBrawlerRarityId.LEGENDARY