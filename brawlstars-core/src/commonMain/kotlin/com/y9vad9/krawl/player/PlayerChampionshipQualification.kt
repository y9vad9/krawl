package com.y9vad9.krawl.player

/**
 * Represents whether a Brawl Stars player is currently qualified
 * from the ongoing Championship Challenge or Monthly Qualifier event.
 *
 * This flag typically reflects real-time status returned by the API
 * and may vary depending on the season and region.
 *
 * @property isQualified `true` if the player is currently qualified
 * for the Brawl Stars Championship; `false` otherwise.
 *
 * @see <a href="https://esports.brawlstars.com/">Brawl Stars Esports</a>
 */
@JvmInline
public value class PlayerChampionshipQualification(
    public val isQualified: Boolean,
)
