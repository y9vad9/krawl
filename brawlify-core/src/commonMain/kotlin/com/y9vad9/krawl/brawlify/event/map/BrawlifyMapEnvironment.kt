package com.y9vad9.krawl.brawlify.event.map

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyMapEnvironment
import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyUrl

/**
 * Represents an environment or map setting within the game,
 * associated with a specific game mode.
 *
 * @property id The unique identifier of the game mode environment.
 * @property name The human-readable name of the game mode environment.
 * @property pathSegment A path segment associated with the environment.
 *                       The identification when resolving resources yourself.
 * @property path The path segment representing this environment, used in URLs
 *                or resource identification.
 * @property version The version number of the environment data.
 * @property imageUrl A URL pointing to an image representing this environment.
 */
public data class BrawlifyMapEnvironment(
    public val id: BrawlifyMapEnvironmentId,
    public val name: BrawlifyMapEnvironmentName,
    public val pathSegment: BrawlifyPathSegment,
    public val path: BrawlifyPathSegment,
    public val version: BrawlifyMapEnvironmentVersion,
    public val imageUrl: BrawlifyUrl,
)

/**
 * Converts this [RawBrawlifyMapEnvironment] into its typed and validated counterpart [BrawlifyMapEnvironment].
 *
 * @return the corresponding [BrawlifyMapEnvironment] instance
 * @throws IllegalArgumentException if any validation fails or the contract is broken
 */
public fun RawBrawlifyMapEnvironment.toTypedOrThrow(): BrawlifyMapEnvironment =
    BrawlifyMapEnvironment(
        id = BrawlifyMapEnvironmentId(id),
        name = BrawlifyMapEnvironmentName(name),
        pathSegment = BrawlifyPathSegment(hash),
        path = BrawlifyPathSegment(path),
        version = BrawlifyMapEnvironmentVersion.createOrThrow(version),
        imageUrl = BrawlifyUrl.createOrThrow(imageUrl),
    )

/**
 * Attempts to convert this [RawBrawlifyMapEnvironment] into its typed counterpart [BrawlifyMapEnvironment].
 *
 * @return the validated [BrawlifyMapEnvironment], or `null` if conversion fails
 */
public fun RawBrawlifyMapEnvironment.toTypedOrNull(): BrawlifyMapEnvironment? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }

/** Returns `true` if this environment is the default environment. */
public val BrawlifyMapEnvironment.isDefault: Boolean
    get() = id.isDefault

/** Returns `true` if this environment is the Katana Kingdom. */
public val BrawlifyMapEnvironment.isKatanaKingdom: Boolean
    get() = id.isKatanaKingdom

/** Returns `true` if this environment is the Mine. */
public val BrawlifyMapEnvironment.isMine: Boolean
    get() = id.isMine

/** Returns `true` if this environment is the Hub. */
public val BrawlifyMapEnvironment.isHub: Boolean
    get() = id.isHub

/** Returns `true` if this environment is Arcades Showdown. */
public val BrawlifyMapEnvironment.isArcadesShowdown: Boolean
    get() = id.isArcadesShowdown

/** Returns `true` if this environment is Default Showdown. */
public val BrawlifyMapEnvironment.isDefaultShowdown: Boolean
    get() = id.isDefaultShowdown

/** Returns `true` if this environment is Grassfield. */
public val BrawlifyMapEnvironment.isGrassfield: Boolean
    get() = id.isGrassfield

/** Returns `true` if this environment is Islands Showdown. */
public val BrawlifyMapEnvironment.isIslandsShowdown: Boolean
    get() = id.isIslandsShowdown

/** Returns `true` if this environment is Stunt Show Brawl Ball. */
public val BrawlifyMapEnvironment.isStuntShowBrawlBall: Boolean
    get() = id.isStuntShowBrawlBall

/** Returns `true` if this environment is Grassfield Beach Ball. */
public val BrawlifyMapEnvironment.isGrassfieldBeachBall: Boolean
    get() = id.isGrassfieldBeachBall

/** Returns `true` if this environment is Stunt Show. */
public val BrawlifyMapEnvironment.isStuntShow: Boolean
    get() = id.isStuntShow

/** Returns `true` if this environment is Scrapyard. */
public val BrawlifyMapEnvironment.isScrapyard: Boolean
    get() = id.isScrapyard

/** Returns `true` if this environment is Mine Train Tracks. */
public val BrawlifyMapEnvironment.isMineTrainTracks: Boolean
    get() = id.isMineTrainTracks

/** Returns `true` if this environment is BrawlbBall Arena. */
public val BrawlifyMapEnvironment.isBrawlBallArena: Boolean
    get() = id.isBrawlBallArena

/** Returns `true` if this environment is Loveswamp. */
public val BrawlifyMapEnvironment.isLoveswamp: Boolean
    get() = id.isLoveswamp

/** Returns `true` if this environment is Enchanted Forest. */
public val BrawlifyMapEnvironment.isEnchantedForest: Boolean
    get() = id.isEnchantedForest

/** Returns `true` if this environment is Stunt Show Volley. */
public val BrawlifyMapEnvironment.isStuntShowVolley: Boolean
    get() = id.isStuntShowVolley

/** Returns `true` if this environment is Rooftop. */
public val BrawlifyMapEnvironment.isRooftop: Boolean
    get() = id.isRooftop

/** Returns `true` if this environment is Tropicall Islands Showdown. */
public val BrawlifyMapEnvironment.isTropicallIslandsShowdown: Boolean
    get() = id.isTropicallIslandsShowdown

/** Returns `true` if this environment is Mortuary Volley. */
public val BrawlifyMapEnvironment.isMortuaryVolley: Boolean
    get() = id.isMortuaryVolley

/** Returns `true` if this environment is Tropicall Islands Brawl Ball. */
public val BrawlifyMapEnvironment.isTropicalIslandsBrawlBall: Boolean
    get() = id.isTropicalIslandsBrawlBall

/** Returns `true` if this environment is Coin Factory BrawlbBall. */
public val BrawlifyMapEnvironment.isCoinFactoryBrawlbBall: Boolean
    get() = id.isCoinFactoryBrawlbBall

/** Returns `true` if this environment is Coin Factory. */
public val BrawlifyMapEnvironment.isCoinFactory: Boolean
    get() = id.isCoinFactory

/** Returns `true` if this environment is Bazaaris Islands Showdown. */
public val BrawlifyMapEnvironment.isBazaarisIslandsShowdown: Boolean
    get() = id.isBazaarisIslandsShowdown

/** Returns `true` if this environment is Air Hockey. */
public val BrawlifyMapEnvironment.isAirHockey: Boolean
    get() = id.isAirHockey

/** Returns `true` if this environment is Hockey Islands. */
public val BrawlifyMapEnvironment.isHockeyIslands: Boolean
    get() = id.isHockeyIslands

/** Returns `true` if this environment is Katana Kingdom Showdown. */
public val BrawlifyMapEnvironment.isKatanaKingdomShowdown: Boolean
    get() = id.isKatanaKingdomShowdown

/** Returns `true` if this environment is Katana Kingdom Islands Showdown. */
public val BrawlifyMapEnvironment.isKatanaKingdomIslandsShowdown: Boolean
    get() = id.isKatanaKingdomIslandsShowdown

/** Returns true if this environment is Katana Kingdom themed. */
public val BrawlifyMapEnvironment.isAnyKatanaKingdom: Boolean
    get() = id.isAnyKatanaKingdom

/** Returns true if this environment is Stunt Show themed. */
public val BrawlifyMapEnvironment.isAnyStuntShow: Boolean
    get() = id.isAnyStuntShow

/** Returns true if this environment is Coin Factory themed. */
public val BrawlifyMapEnvironment.isAnyCoinFactory: Boolean
    get() = id.isAnyCoinFactory
