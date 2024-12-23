package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyRate private constructor(public val raw: Double) {
    public companion object : ValueConstructor<BrawlifyRate, Double> {
        public val RANGE: ClosedFloatingPointRange<Double> = 0.0..100.0

        override fun create(value: Double): Result<BrawlifyRate> {
            if (value !in RANGE) return Result.failure(CreationFailure.ofRange(RANGE))
            return Result.success(BrawlifyRate(value))
        }
    }
}