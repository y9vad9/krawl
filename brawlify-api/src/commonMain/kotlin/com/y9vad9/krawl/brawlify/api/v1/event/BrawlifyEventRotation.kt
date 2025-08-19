package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.Serializable

/**
 * Represents the rotation of Brawlify events, including currently active and upcoming events.
 *
 * @property active List of events that are currently active in the rotation.
 * @property upcoming List of events that will be active in the near future.
 */
@Serializable
public data class BrawlifyEventRotation(
    public val active: List<BrawlifyEvent>,
    public val upcoming: List<BrawlifyEvent>,
)
