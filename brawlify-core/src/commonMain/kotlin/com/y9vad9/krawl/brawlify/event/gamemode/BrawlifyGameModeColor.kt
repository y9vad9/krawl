package com.y9vad9.krawl.brawlify.event.gamemode

import com.y9vad9.krawl.common.HexColor

/**
 * Represents the color scheme associated with a Brawl Stars game mode.
 *
 * @property background The background color, represented as a hexadecimal color code.
 * @property primary The primary accent color, represented as a hexadecimal color code.
 */
public data class BrawlifyGameModeColor(
    public val background: HexColor,
    public val primary: HexColor,
)
