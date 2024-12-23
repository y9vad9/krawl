package com.y9vad9.brawlifyapi.internal

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object InstantFromUnixMillisecondsSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder): Instant {
        return decoder.decodeLong().let { Instant.fromEpochMilliseconds(it) }
    }

    override fun serialize(encoder: Encoder, value: Instant) {
        return encoder.encodeLong(value.toEpochMilliseconds())
    }
}