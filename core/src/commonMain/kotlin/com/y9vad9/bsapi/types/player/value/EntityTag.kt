package com.y9vad9.bsapi.types.player.value

import com.y9vad9.bsapi.annotations.ContextualBSApi
import com.y9vad9.bsapi.internal.EntityTagSerializer
import kotlinx.serialization.Serializable
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents a tag that can be associated with either a [PlayerTag] or a [BotTag].
 * This interface allows common operations to be performed on both player and bot tags, such as
 * checking their type, manipulating their raw values, and converting them between formats.
 *
 * This is a sealed interface to provide a type-safe way of distinguishing between player and bot tags.
 */
@Serializable(with = EntityTagSerializer::class)
public sealed interface EntityTag {
    /**
     * The raw string representation of the tag.
     *
     * **Better not to use its raw form – it can be in different forms**. Use
     * [withHashTag] and [withoutHashTag] instead.
     */
    @ContextualBSApi
    public val raw: String
}

/**
 * Extension property that returns the raw tag string without the '#' character.
 */
public val EntityTag.withoutHashTag: String
    get() = raw.replace("#", "")

/**
 * Extension property that returns the raw tag string with a leading '#' character.
 * If the tag already contains a '#', it is returned as is.
 */
public val EntityTag.withHashTag: String
    get() = if (raw.contains("#")) raw else "#$raw"

/**
 * Checks if the current [EntityTag] is a [PlayerTag].
 *
 * @return `true` if this [EntityTag] is a [PlayerTag], `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
public fun EntityTag.isPlayer(): Boolean {
    contract {
        returns(true) implies (this@isPlayer is PlayerTag)
        returns(false) implies (this@isPlayer is BotTag)
    }

    return this is PlayerTag
}

/**
 * Checks if the current [EntityTag] is a [BotTag].
 *
 * @return `true` if this [EntityTag] is a [BotTag], `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
public fun EntityTag.isBot(): Boolean {
    contract {
        returns(true) implies (this@isBot is BotTag)
        returns(false) implies (this@isBot is PlayerTag)
    }

    return this is BotTag
}

/**
 * Returns the [PlayerTag] if this [EntityTag] is a [PlayerTag].
 * Throws an error if the tag is not a [PlayerTag].
 *
 * @throws IllegalArgumentException if the [EntityTag] is not a [PlayerTag].
 */
public fun EntityTag.requirePlayer(): PlayerTag {
    return if (isPlayer()) this else error("The entity tag '$this' is not a player tag.")
}

/**
 * Returns the [BotTag] if this [EntityTag] is a [BotTag].
 * Throws an error if the tag is not a [BotTag].
 *
 * @throws IllegalArgumentException if the [EntityTag] is not a [BotTag].
 */
public fun EntityTag.requireBot(): BotTag {
    return if (isBot()) this else error("The entity tag '$this' is not a bot tag.")
}

/**
 * Returns the [PlayerTag] if this [EntityTag] is a [PlayerTag], or `null` if it is not.
 */
public fun EntityTag.playerOrNull(): PlayerTag? {
    return if (isPlayer()) this else null
}

/**
 * Returns the [BotTag] if this [EntityTag] is a [BotTag], or `null` if it is not.
 */
public fun EntityTag.botOrNull(): BotTag? {
    return if (isBot()) this else null
}
