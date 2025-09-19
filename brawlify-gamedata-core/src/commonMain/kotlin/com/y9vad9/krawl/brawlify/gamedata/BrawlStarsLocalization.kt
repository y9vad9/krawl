package com.y9vad9.krawl.brawlify.gamedata

import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawler
import com.y9vad9.krawl.brawlify.BrawlStarsLocale
import com.y9vad9.krawl.brawlify.BrawlStarsTID
import com.y9vad9.krawl.brawlify.event.map.BrawlifyMap
import com.y9vad9.krawl.event.battle.brawler.BattleBrawler

/**
 * Client interface for retrieving localized strings from the Brawlify Game Data API.
 *
 * This interface provides access to static game localization data (e.g., unit names, abilities, UI strings)
 * using a [BrawlStarsLocale] and [BrawlStarsTID] (translation ID).
 *
 * Implementations are expected to be generated at build time using code generation
 * based on the latest Brawlify game data snapshots.
 *
 * Note: This API is marked as experimental because the structure and content of
 * the underlying Brawlify localization data may change without notice.
 *
 * @see BrawlStarsLocale
 * @see BrawlStarsTID
 * @see UnstableBrawlifyGameDataApi
 */
@ExperimentalBrawlifyGameDataApi
public interface BrawlStarsLocalization {
    /**
     * Returns a localized string for the specified [tid] in the given [locale], based on Brawlify localization data.
     *
     * @param locale The target locale to retrieve the translation for.
     * @param tid The translation identifier (TID) to resolve into a localized string.
     * @return The localized string, or a null if not found.
     */
    public fun getString(locale: BrawlStarsLocale, tid: BrawlStarsTID): String?

    /**
     * Produces a localized representation of the given [brawler] for the specified [locale].
     *
     * The resulting [BrawlifyBrawler] contains translated fields such as name, description,
     * gadgets, star powers, and other localized metadata based on Brawlify localization data.
     *
     * @param locale The locale to localize the brawler information for.
     * @param brawler The raw [BattleBrawler] to be localized.
     * @return A [BrawlifyBrawler] enriched with localized content or null if brawler not found.
     */
    public fun localize(locale: BrawlStarsLocale, brawler: BrawlifyBrawler): BrawlifyBrawler?

    /**
     * Returns a localized version of the given [BrawlifyMap] for the specified [locale].
     *
     * This function attempts to translate relevant fields of the map, such as its name and environment,
     * based on localization data corresponding to the provided locale.
     *
     * @param locale The target locale for localization.
     * @param map The map instance to be localized.
     * @return A new [BrawlifyMap] with localized content, or `null` if localization data is unavailable.
     */
    public fun localize(locale: BrawlStarsLocale, map: BrawlifyMap): BrawlifyMap?
}

/**
 * Attempts to localize the given [brawler] for the specified [locale], returning the original
 * [brawler] instance if localization is not available.
 *
 * This is useful when localization is optional and the original (untranslated) data is acceptable as-is.
 *
 * @param locale The locale to apply for localization.
 * @param brawler The [BrawlifyBrawler] to localize.
 * @return The localized [BrawlifyBrawler], or the original instance if localization is unavailable.
 */
@ExperimentalBrawlifyGameDataApi
public fun BrawlStarsLocalization.tryLocalize(
    locale: BrawlStarsLocale,
    brawler: BrawlifyBrawler,
): BrawlifyBrawler = localize(locale, brawler) ?: brawler
