package com.y9vad9.krawl.event

import kotlin.jvm.JvmInline

/**
 * Represents a ranked stage in the game's competitive ranking system.
 *
 * Each `RankedStage` is identified by its [ordinal], which determines its position in the overall progression,
 * starting from the lowest stage (e.g. Bronze I) to the highest (e.g. Legendary III or beyond).
 *
 * This class implements [Comparable], allowing stages to be compared based on their [ordinal] values.
 *
 * ## Notes
 * - `RankedStage` is a value class for efficiency and type safety.
 * - Higher [ordinal] values represent higher ranked stages.
 */
@JvmInline
public value class RankedStage(public val ordinal: Int) : Comparable<RankedStage> {

    /**
     * Returns true if this RankedStage ordinal is greater than or equal to [min].
     *
     * Useful for checking if player has reached at least a certain rank.
     *
     * @param min The minimum RankedStage to compare against.
     * @return `true` if this stage is at least [min], otherwise `false`.
     */
    public fun isAtLeast(min: RankedStage): Boolean = this.ordinal >= min.ordinal

    /** Constants with constraints and validation */
    public companion object {
        /** Bronze tier stage 1 (lowest entry rank). */
        public val BRONZE_ONE: RankedStage = RankedStage(1)

        /** Bronze tier stage 2. */
        public val BRONZE_TWO: RankedStage = RankedStage(2)

        /** Bronze tier stage 3 (final Bronze stage before Silver). */
        public val BRONZE_THREE: RankedStage = RankedStage(3)

        /** Silver tier stage 1. */
        public val SILVER_ONE: RankedStage = RankedStage(4)

        /** Silver tier stage 2. */
        public val SILVER_TWO: RankedStage = RankedStage(5)

        /** Silver tier stage 3 (final Silver stage). */
        public val SILVER_THREE: RankedStage = RankedStage(6)

        /** Gold tier stage 1. */
        public val GOLD_ONE: RankedStage = RankedStage(7)

        /** Gold tier stage 2. */
        public val GOLD_TWO: RankedStage = RankedStage(8)

        /** Gold tier stage 3 (final Gold). */
        public val GOLD_THREE: RankedStage = RankedStage(9)

        /** Diamond tier stage 1. */
        public val DIAMOND_ONE: RankedStage = RankedStage(10)

        /** Diamond tier stage 2. */
        public val DIAMOND_TWO: RankedStage = RankedStage(11)

        /** Diamond tier stage 3 (final Diamond before Mythic). */
        public val DIAMOND_THREE: RankedStage = RankedStage(12)

        /** Mythic tier stage 1. */
        public val MYTHIC_ONE: RankedStage = RankedStage(13)

        /** Mythic tier stage 2. */
        public val MYTHIC_TWO: RankedStage = RankedStage(14)

        /** Mythic tier stage 3 (final Mythic before Legendary). */
        public val MYTHIC_THREE: RankedStage = RankedStage(15)

        /** Legendary tier stage 1. */
        public val LEGENDARY_ONE: RankedStage = RankedStage(16)

        /** Legendary tier stage 2. */
        public val LEGENDARY_TWO: RankedStage = RankedStage(17)

        /** Legendary tier stage 3 (final Legendary before Masters). */
        public val LEGENDARY_THREE: RankedStage = RankedStage(18)

        /** Master tier stage 1 (first Master stage). */
        public val MASTER_ONE: RankedStage = RankedStage(19)

        /** Master tier stage 2. */
        public val MASTER_TWO: RankedStage = RankedStage(20)

        /** Master tier stage 3 (highest official ranked stage below Pro). */
        public val MASTER_THREE: RankedStage = RankedStage(21)
    }

    /**
     * Compares this [RankedStage] to another based on their ordinal values.
     *
     * @param other The other RankedStage to compare to.
     * @return negative if this < other, zero if equal, positive if this > other.
     */
    override fun compareTo(other: RankedStage): Int = ordinal.compareTo(other.ordinal)

    /**
     * Returns a human-readable name for this specific stage, matching the constant’s name if defined.
     *
     * For example, returns `"RankedStage.GOLD_TWO"` for `GOLD_TWO`,
     * or `UnknownRankedStage(ordinal)` if the ordinal is not one of the known constants.
     */
    override fun toString(): String = when (this) {
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
        MASTER_ONE -> "RankedStage.MASTER_ONE"
        MASTER_TWO -> "RankedStage.MASTER_TWO"
        MASTER_THREE -> "RankedStage.MASTER_THREE"
        else -> "RankedStage.UNKNOWN($ordinal)"
    }
}

// --- Bronze ---
/** Returns `true` if this ranked stage is Bronze I. */
public val RankedStage.isBronzeOne: Boolean
    get() = this == RankedStage.BRONZE_ONE

/** Returns `true` if this ranked stage is Bronze II. */
public val RankedStage.isBronzeTwo: Boolean
    get() = this == RankedStage.BRONZE_TWO

/** Returns `true` if this ranked stage is Bronze III. */
public val RankedStage.isBronzeThree: Boolean
    get() = this == RankedStage.BRONZE_THREE

/** Returns `true` if this ranked stage is within any Bronze tier (Bronze I to Bronze III). */
public val RankedStage.isBronze: Boolean
    get() = this.ordinal in RankedStage.BRONZE_ONE.ordinal..RankedStage.BRONZE_THREE.ordinal


// --- Silver ---
/** Returns `true` if this ranked stage is Silver I. */
public val RankedStage.isSilverOne: Boolean
    get() = this == RankedStage.SILVER_ONE

/** Returns `true` if this ranked stage is Silver II. */
public val RankedStage.isSilverTwo: Boolean
    get() = this == RankedStage.SILVER_TWO

/** Returns `true` if this ranked stage is Silver III. */
public val RankedStage.isSilverThree: Boolean
    get() = this == RankedStage.SILVER_THREE

/** Returns `true` if this ranked stage is within any Silver tier (Silver I to Silver III). */
public val RankedStage.isSilver: Boolean
    get() = this.ordinal in RankedStage.SILVER_ONE.ordinal..RankedStage.SILVER_THREE.ordinal


// --- Gold ---
/** Returns `true` if this ranked stage is Gold I. */
public val RankedStage.isGoldOne: Boolean
    get() = this == RankedStage.GOLD_ONE

/** Returns `true` if this ranked stage is Gold II. */
public val RankedStage.isGoldTwo: Boolean
    get() = this == RankedStage.GOLD_TWO

/** Returns `true` if this ranked stage is Gold III. */
public val RankedStage.isGoldThree: Boolean
    get() = this == RankedStage.GOLD_THREE

/** Returns `true` if this ranked stage is within any Gold tier (Gold I to Gold III). */
public val RankedStage.isGold: Boolean
    get() = this.ordinal in RankedStage.GOLD_ONE.ordinal..RankedStage.GOLD_THREE.ordinal


// --- Diamond ---
/** Returns `true` if this ranked stage is Diamond I. */
public val RankedStage.isDiamondOne: Boolean
    get() = this == RankedStage.DIAMOND_ONE

/** Returns `true` if this ranked stage is Diamond II. */
public val RankedStage.isDiamondTwo: Boolean
    get() = this == RankedStage.DIAMOND_TWO

/** Returns `true` if this ranked stage is Diamond III. */
public val RankedStage.isDiamondThree: Boolean
    get() = this == RankedStage.DIAMOND_THREE

/** Returns `true` if this ranked stage is within any Diamond tier (Diamond I to Diamond III). */
public val RankedStage.isDiamond: Boolean
    get() = this.ordinal in RankedStage.DIAMOND_ONE.ordinal..RankedStage.DIAMOND_THREE.ordinal


// --- Mythic ---
/** Returns `true` if this ranked stage is Mythic I. */
public val RankedStage.isMythicOne: Boolean
    get() = this == RankedStage.MYTHIC_ONE

/** Returns `true` if this ranked stage is Mythic II. */
public val RankedStage.isMythicTwo: Boolean
    get() = this == RankedStage.MYTHIC_TWO

/** Returns `true` if this ranked stage is Mythic III. */
public val RankedStage.isMythicThree: Boolean
    get() = this == RankedStage.MYTHIC_THREE

/** Returns `true` if this ranked stage is within any Mythic tier (Mythic I to Mythic III). */
public val RankedStage.isMythic: Boolean
    get() = this.ordinal in RankedStage.MYTHIC_ONE.ordinal..RankedStage.MYTHIC_THREE.ordinal

// --- Legendary ---
/** Returns `true` if this ranked stage is Legendary I. */
public val RankedStage.isLegendaryOne: Boolean
    get() = this == RankedStage.LEGENDARY_ONE

/** Returns `true` if this ranked stage is Legendary II. */
public val RankedStage.isLegendaryTwo: Boolean
    get() = this == RankedStage.LEGENDARY_TWO

/** Returns `true` if this ranked stage is Legendary III. */
public val RankedStage.isLegendaryThree: Boolean
    get() = this == RankedStage.LEGENDARY_THREE

/** Returns `true` if this ranked stage is within any Legendary tier (Legendary I to Legendary III). */
public val RankedStage.isLegendary: Boolean
    get() = this.ordinal in RankedStage.LEGENDARY_ONE.ordinal..RankedStage.LEGENDARY_THREE.ordinal


// --- Master ---
/** Returns `true` if this ranked stage is Master I. */
public val RankedStage.isMasterOne: Boolean
    get() = this == RankedStage.MASTER_ONE

/** Returns `true` if this ranked stage is Master II. */
public val RankedStage.isMasterTwo: Boolean
    get() = this == RankedStage.MASTER_TWO

/** Returns `true` if this ranked stage is Master III. */
public val RankedStage.isMasterThree: Boolean
    get() = this == RankedStage.MASTER_THREE

/** Returns `true` if this ranked stage is within any Master tier (Master I to Master III). */
public val RankedStage.isMaster: Boolean
    get() = this.ordinal in RankedStage.MASTER_ONE.ordinal..RankedStage.MASTER_THREE.ordinal

// Bronze

/** Returns true if this stage is at least Bronze I. */
public val RankedStage.isAtLeastBronzeOne: Boolean
    get() = isAtLeast(RankedStage.BRONZE_ONE)

/** Returns true if this stage is at least Bronze II. */
public val RankedStage.isAtLeastBronzeTwo: Boolean
    get() = isAtLeast(RankedStage.BRONZE_TWO)

/** Returns true if this stage is at least Bronze III. */
public val RankedStage.isAtLeastBronzeThree: Boolean
    get() = isAtLeast(RankedStage.BRONZE_THREE)


// Silver

/** Returns true if this stage is at least Silver I. */
public val RankedStage.isAtLeastSilverOne: Boolean
    get() = isAtLeast(RankedStage.SILVER_ONE)

/** Returns true if this stage is at least Silver II. */
public val RankedStage.isAtLeastSilverTwo: Boolean
    get() = isAtLeast(RankedStage.SILVER_TWO)

/** Returns true if this stage is at least Silver III. */
public val RankedStage.isAtLeastSilverThree: Boolean
    get() = isAtLeast(RankedStage.SILVER_TWO)


// Gold

/** Returns true if this stage is at least Gold I. */
public val RankedStage.isAtLeastGoldOne: Boolean
    get() = isAtLeast(RankedStage.GOLD_ONE)

/** Returns true if this stage is at least Gold II. */
public val RankedStage.isAtLeastGoldTwo: Boolean
    get() = isAtLeast(RankedStage.GOLD_TWO)

/** Returns true if this stage is at least Gold III. */
public val RankedStage.isAtLeastGoldThree: Boolean
    get() = isAtLeast(RankedStage.GOLD_THREE)

// Diamond

/** Returns true if this stage is at least Diamond I. */
public val RankedStage.isAtLeastDiamondOne: Boolean
    get() = isAtLeast(RankedStage.DIAMOND_ONE)

/** Returns true if this stage is at least Diamond II. */
public val RankedStage.isAtLeastDiamondTwo: Boolean
    get() = isAtLeast(RankedStage.DIAMOND_TWO)

/** Returns true if this stage is at least Diamond III. */
public val RankedStage.isAtLeastDiamondThree: Boolean get() = isAtLeast(RankedStage.DIAMOND_THREE)


// Mythic

/** Returns true if this stage is at least Mythic I. */
public val RankedStage.isAtLeastMythicOne: Boolean
    get() = isAtLeast(RankedStage.MYTHIC_ONE)

/** Returns true if this stage is at least Mythic II. */
public val RankedStage.isAtLeastMythicTwo: Boolean
    get() = isAtLeast(RankedStage.MYTHIC_TWO)

/** Returns true if this stage is at least Mythic III. */
public val RankedStage.isAtLeastMythicThree: Boolean
    get() = isAtLeast(RankedStage.MYTHIC_THREE)


// Legendary

/** Returns true if this stage is at least Legendary I. */
public val RankedStage.isAtLeastLegendaryOne: Boolean get() = isAtLeast(RankedStage.LEGENDARY_ONE)

/** Returns true if this stage is at least Legendary II. */
public val RankedStage.isAtLeastLegendaryTwo: Boolean get() = isAtLeast(RankedStage.LEGENDARY_TWO)

/** Returns true if this stage is at least Legendary III. */
public val RankedStage.isAtLeastLegendaryThree: Boolean get() = isAtLeast(RankedStage.LEGENDARY_THREE)


// Master

/** Returns true if this stage is at least Master I. */
public val RankedStage.isAtLeastMasterOne: Boolean
    get() = isAtLeast(RankedStage.MASTER_ONE)

/** Returns true if this stage is at least Master II. */
public val RankedStage.isAtLeastMasterTwo: Boolean get() = isAtLeast(RankedStage.MASTER_TWO)
