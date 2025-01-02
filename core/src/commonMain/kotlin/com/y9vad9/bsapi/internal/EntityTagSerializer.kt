package com.y9vad9.bsapi.internal

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.createUnsafe
import com.y9vad9.bsapi.types.player.value.BotTag
import com.y9vad9.bsapi.types.player.value.EntityTag
import com.y9vad9.bsapi.types.player.value.PlayerTag
import com.y9vad9.bsapi.types.player.value.withHashTag
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EntityTagSerializer : KSerializer<EntityTag> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("EntityTag", PrimitiveKind.STRING)

    @OptIn(ValueConstructor.Unsafe::class)
    override fun deserialize(decoder: Decoder): EntityTag {
        val value = decoder.decodeString().replace("#", "")

        return when (value.length) {
            // bot's tags are 3 symbols (or four if with hashtag)
            3 -> BotTag.createUnsafe(value)
            else -> PlayerTag.createUnsafe(value)
        }
    }

    override fun serialize(encoder: Encoder, value: EntityTag) {
        encoder.encodeString(value.withHashTag)
    }

}