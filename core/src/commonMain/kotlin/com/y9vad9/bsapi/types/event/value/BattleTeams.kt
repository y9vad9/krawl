package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.event.Battle
import com.y9vad9.bsapi.types.exception.CreationFailure
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BattleTeams(public val raw: List<List<Battle.PlayerView>>) {
    public val first: List<Battle.PlayerView> get() = raw[0]
    public val second: List<Battle.PlayerView> get() = raw[1]

    public companion object : ValueConstructor<BattleTeams, List<List<Battle.PlayerView>>> {
        override fun create(value: List<List<Battle.PlayerView>>): Result<BattleTeams> {
            return when (value.size) {
                2 -> Result.success(BattleTeams(value))
                else -> Result.failure(CreationFailure.ofSizeExact(2))
            }
        }
    }
}

public fun BattleTeams.findPlayer(tag: PlayerTag): Battle.PlayerView? {
    first.firstOrNull { it.tag == tag }?.let { return it }
    second.firstOrNull { it.tag == tag }?.let { return it }

    return null
}