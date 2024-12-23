package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.createUnsafe
import kotlinx.serialization.Serializable

/**
 * Represents trophies in Brawl Stars. Might be both positive and negative
 * depending on the context.
 *
 * In the context of Player, it's always positive, but, as for battles, can be negative.
 */
@Serializable
@JvmInline
public value class Trophies private constructor(public val raw: Int) : Comparable<Trophies> {
    public companion object : ValueConstructor<Trophies, Int> {
        public val ZERO: Trophies = Trophies(0)

        override fun create(value: Int): Result<Trophies> {
            return Result.success(Trophies(value))
        }
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

public val Trophies.isPositive: Boolean get() = raw < 0
public val Trophies.isNegative: Boolean get() = raw < 0

@ValueConstructor.Unsafe
internal fun Trophies.asRankedStageUnsafe(): RankedStage = RankedStage.createUnsafe(raw)