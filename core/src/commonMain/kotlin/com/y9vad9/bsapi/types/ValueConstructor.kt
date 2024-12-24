package com.y9vad9.bsapi.types

import com.y9vad9.bsapi.types.exception.CreationFailure

/**
 * Abstraction for factories that construct value objects.
 * The following pattern should be applied to the factories:
 * - Factory should be in companion object that does only one thing – constructing.
 * - Validation information (like sizes or patterns) should be on the top of
 * the factories for better readability.
 * - After validation information comes [create] and, if needed, constants
 * with messages below the method.
 */
public interface ValueConstructor<Type, WrappedType> {
    /**
     * Denotes that you create a value-type without a proper check that
     * might lead to runtime exceptions.
     */
    @RequiresOptIn(message = "This declaration might throw runtime exceptions without proper check.")
    public annotation class Unsafe

    /**
     * Instantiates the entity of given type [Type].
     *
     * **Shouldn't throw anything, but instantiate object of type [Type] if possible**
     */
    public fun create(
        value: WrappedType,
    ): Result<Type>
}

public inline fun <T, W> ValueConstructor<T, W>.createOr(
    value: W,
    otherwise: (CreationFailure) -> T,
): T {
    return create(value).getOrElse {
        otherwise(it as CreationFailure)
    }
}

public fun <T, W> ValueConstructor<T, W>.createOrNull(
    value: W,
): T? = create(value).getOrNull()


@ValueConstructor.Unsafe
@Throws(CreationFailure::class)
public fun <T, W> ValueConstructor<T, W>.createUnsafe(value: W): T {
    return create(value).getOrThrow()
}