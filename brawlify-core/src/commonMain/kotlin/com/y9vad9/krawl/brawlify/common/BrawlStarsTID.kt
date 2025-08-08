package com.y9vad9.krawl.brawlify.common

/**
 * Represents a Brawl Stars Translation Identifier (TID), a stable string-based key used throughout game data.
 *
 * A `BrawlStarsTID` serves as a unique identifier within Brawl Stars' internal game files and is used
 * to reference various in-game entities such as brawlers, abilities, gadgets, UI elements, game modes,
 * and other structured data.
 *
 * While often used in localization contexts to resolve human-readable text, TIDs also serve as cross-references
 * between different parts of the game's structured data model and are essential for linking definitions.
 *
 * @property rawString The raw identifier string as defined in the game data.
 */
@JvmInline
public value class BrawlStarsTID(public val rawString: String)
