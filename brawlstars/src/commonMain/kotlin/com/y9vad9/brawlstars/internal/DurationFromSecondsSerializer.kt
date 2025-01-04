package com.y9vad9.brawlstars.internal

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

internal object DurationFromSecondsSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Duration", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder): Duration {
        return decoder.decodeInt().seconds
    }

    override fun serialize(encoder: Encoder, value: Duration) {
        encoder.encodeLong(value.inWholeSeconds)
    }

}