package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class RankedStage private constructor(public val raw: Int) : Comparable<RankedStage> {
    public companion object : ValueConstructor<RankedStage, Int> {
        public val BRONZE_ONE: RankedStage = RankedStage(1)
        public val BRONZE_TWO: RankedStage = RankedStage(2)
        public val BRONZE_THREE: RankedStage = RankedStage(3)

        public val SILVER_ONE: RankedStage = RankedStage(4)
        public val SILVER_TWO: RankedStage = RankedStage(5)
        public val SILVER_THREE: RankedStage = RankedStage(6)

        public val GOLD_ONE: RankedStage = RankedStage(7)
        public val GOLD_TWO: RankedStage = RankedStage(8)
        public val GOLD_THREE: RankedStage = RankedStage(9)

        public val DIAMOND_ONE: RankedStage = RankedStage(10)
        public val DIAMOND_TWO: RankedStage = RankedStage(11)
        public val DIAMOND_THREE: RankedStage = RankedStage(12)

        public val MYTHIC_ONE: RankedStage = RankedStage(13)
        public val MYTHIC_TWO: RankedStage = RankedStage(14)
        public val MYTHIC_THREE: RankedStage = RankedStage(15)

        public val LEGENDARY_ONE: RankedStage = RankedStage(16)
        public val LEGENDARY_TWO: RankedStage = RankedStage(17)
        public val LEGENDARY_THREE: RankedStage = RankedStage(18)

        override fun create(value: Int): Result<RankedStage> {
            return Result.success(RankedStage(value))
        }
    }

    override fun compareTo(other: RankedStage): Int {
        return raw.compareTo(other.raw)
    }
}

public val RankedStage.isMaster: Boolean
    get() = this > RankedStage.LEGENDARY_THREE