package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerClass

/**
 * Represents a brawler class in Brawlify's data model.
 *
 * A brawler class groups brawlers by shared roles or attributes, such as "Assassin", "Tank", or "Support".
 * This class contains a unique identifier and a display name for the class.
 *
 * @property id Unique identifier for the brawler class.
 * @property name Human-readable name of the brawler class.
 */
public data class BrawlifyBrawlerClass(
    public val id: BrawlifyBrawlerClassId,
    public val name: BrawlifyBrawlerClassName,
)

/**
 * Converts this [RawBrawlifyBrawlerClass] into its validated and
 * typed counterpart [BrawlifyBrawlerClass].
 */
public fun RawBrawlifyBrawlerClass.toTypedOrThrow(): BrawlifyBrawlerClass =
    BrawlifyBrawlerClass(
        id = BrawlifyBrawlerClassId(id),
        name = BrawlifyBrawlerClassName.from(name),
    )

/** Returns `true` if this brawler class represents an unknown class. */
public val BrawlifyBrawlerClass.isUnknown: Boolean
    get() = id.isUnknown

/** Returns `true` if this brawler class represents a damage dealer. */
public val BrawlifyBrawlerClass.isDamageDealer: Boolean
    get() = id.isDamageDealer

/** Returns `true` if this brawler class represents a tank. */
public val BrawlifyBrawlerClass.isTank: Boolean
    get() = id.isTank

/** Returns `true` if this brawler class represents a marksman. */
public val BrawlifyBrawlerClass.isMarksman: Boolean
    get() = id.isMarksman

/** Returns `true` if this brawler class represents an artillery unit. */
public val BrawlifyBrawlerClass.isArtillery: Boolean
    get() = id.isArtillery

/** Returns `true` if this brawler class represents a controller. */
public val BrawlifyBrawlerClass.isController: Boolean
    get() = id.isController

/** Returns `true` if this brawler class represents an assassin. */
public val BrawlifyBrawlerClass.isAssassin: Boolean
    get() = id.isAssassin

/** Returns `true` if this brawler class represents a support unit. */
public val BrawlifyBrawlerClass.isSupport: Boolean
    get() = id.isSupport
