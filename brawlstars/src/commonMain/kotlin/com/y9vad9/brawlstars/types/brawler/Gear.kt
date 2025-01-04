package com.y9vad9.brawlstars.types.brawler

import com.y9vad9.brawlstars.types.brawler.value.GearName
import com.y9vad9.brawlstars.types.event.value.EventSlotId
import kotlinx.serialization.Serializable

@Serializable
public data class Gear(
    val id: EventSlotId,
    val name: GearName,
)