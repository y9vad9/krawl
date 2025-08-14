package com.y9vad9.krawl.event

import kotlin.jvm.JvmInline

/**
 * Represents the name of a Brawl Stars map as a raw [String] value.
 *
 * This value is taken directly from the Brawl Stars API and reflects the localized
 * or internal name of the map associated with an event or mode.
 *
 * Note: The map name is not guaranteed to be unique across all time and modes.
 * It's primarily useful for display or identification in the context of a specific [Event].
 *
 * @property string The raw name of the map.
 */
@JvmInline
public value class MapName(public val string: String)
