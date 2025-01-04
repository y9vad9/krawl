package com.y9vad9.brawlstars.types.event.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class RankedStage private constructor(public val raw: Int) : Comparable<RankedStage> {
    public companion object : ValueFactory<RankedStage, Int> by factory(
        rules = listOf(ValueRangeValidationRule(1..19)),
        constructor = ::RankedStage,
    ) {
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
        public val MASTER: RankedStage = RankedStage(19)
    }

    override fun compareTo(other: RankedStage): Int {
        return raw.compareTo(other.raw)
    }

    override fun toString(): String {
        return when (this) {
            BRONZE_ONE -> "RankedStage.BRONZE_ONE"
            BRONZE_TWO -> "RankedStage.BRONZE_TWO"
            BRONZE_THREE -> "RankedStage.BRONZE_THREE"
            SILVER_ONE -> "RankedStage.SILVER_ONE"
            SILVER_TWO -> "RankedStage.SILVER_TWO"
            SILVER_THREE -> "RankedStage.SILVER_THREE"
            GOLD_ONE -> "RankedStage.GOLD_ONE"
            GOLD_TWO -> "RankedStage.GOLD_TWO"
            GOLD_THREE -> "RankedStage.GOLD_THREE"
            DIAMOND_ONE -> "RankedStage.DIAMOND_ONE"
            DIAMOND_TWO -> "RankedStage.DIAMOND_TWO"
            DIAMOND_THREE -> "RankedStage.DIAMOND_THREE"
            MYTHIC_ONE -> "RankedStage.MYTHIC_ONE"
            MYTHIC_TWO -> "RankedStage.MYTHIC_TWO"
            MYTHIC_THREE -> "RankedStage.MYTHIC_THREE"
            LEGENDARY_ONE -> "RankedStage.LEGENDARY_ONE"
            LEGENDARY_TWO -> "RankedStage.LEGENDARY_TWO"
            LEGENDARY_THREE -> "RankedStage.LEGENDARY_THREE"
            MASTER -> "RankedStage.MASTER"
            else -> error("Invalid raw value: $raw")
        }
    }
}

public val RankedStage.isMaster: Boolean
    get() = this == RankedStage.MASTER