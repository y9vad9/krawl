package com.y9vad9.bsapi.internal

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

import kotlinx.datetime.*
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeComponents.Companion.Format
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.char
import kotlinx.datetime.format.optional
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor


internal object InstantInternalSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Instant {
        return Instant.parse(decoder.decodeString(), customFormat)
    }

    override fun serialize(encoder: Encoder, value: Instant) {
        Instant.toString()
    }

}

private val customFormat: DateTimeFormat<DateTimeComponents> = Format {
    year()
    monthNumber()
    dayOfMonth()
    char('T')
    hour()
    minute()
    second()
    optional {
        char('.')
        secondFraction(1, 3) // Matches `.000`
    }
    char('Z') // Matches the UTC 'Z' suffix
}