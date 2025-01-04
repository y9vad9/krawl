package com.y9vad9.brawlstars.types.event.value

import com.y9vad9.brawlstars.annotations.ContextualBSApi
import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.createOrThrow
import com.y9vad9.ktiny.kotlidator.factory
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Represents trophies in Brawl Stars. Might be both positive and negative
 * depending on the context.
 *
 * In the context of Player, it's always positive, but, as for battles, can be negative.
 */
@Serializable
@JvmInline
public value class Trophies private constructor(public val raw: Int) : Comparable<Trophies> {
    public companion object : ValueFactory<Trophies, Int> by factory(
        constructor = ::Trophies,
    ) {
        public val ZERO: Trophies = Trophies(0)
    }

    public operator fun plus(other: Trophies): Trophies {
        return Trophies(raw + other.raw)
    }

    public operator fun minus(other: Trophies): Trophies {
        return Trophies(raw - other.raw)
    }

    override fun compareTo(other: Trophies): Int {
        return raw.compareTo(other.raw)
    }
}

public val Trophies.isPositive: Boolean get() = raw > 0
public val Trophies.isNegative: Boolean get() = raw < 0

// meaningful only when in context of ranked battles
@ContextualBSApi
public fun Trophies.asRankedStageUnsafe(): RankedStage = RankedStage.createOrThrow(raw)