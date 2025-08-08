package com.y9vad9.krawl.brawler

/**
 * Represents a collection of [Brawler] instances.
 *
 * Provides convenient lookup methods to retrieve a [Brawler] by its unique [BrawlerId].
 *
 * @property list The underlying list of [Brawler] objects contained in this collection.
 */
public class Brawlers(public val list: List<Brawler>) {

    /**
     * A lazily initialized map associating each [BrawlerId] with its corresponding [Brawler].
     * Used internally for efficient lookup operations.
     */
    private val associated: Map<BrawlerId, Brawler> by lazy {
        list.associateBy { it.id }
    }

    /**
     * Returns the [Brawler] associated with the given [id], or `null` if no such brawler exists.
     *
     * @param id The [BrawlerId] to look up.
     * @return The matching [Brawler], or `null` if not found.
     */
    public fun getByIdOrNull(id: BrawlerId): Brawler? = associated[id]

    /**
     * Returns the [Brawler] associated with the given [id].
     *
     * Throws an [IllegalStateException] if no brawler with the given ID is found.
     *
     * @param id The [BrawlerId] to look up.
     * @return The matching [Brawler].
     * @throws IllegalStateException if the brawler is not found.
     */
    public fun getByIdOrThrow(id: BrawlerId): Brawler =
        getByIdOrNull(id) ?: error("Unable to find Brawler with given id: $id.")

    /**
     * Checks whether this [Brawlers] instance is equal to another object.
     *
     * Equality is based on equality of the underlying [list] of [Brawler] objects.
     *
     * @param other The object to compare with.
     * @return `true` if [other] is a [Brawlers] instance with an equal [list], `false` otherwise.
     */
    override fun equals(other: Any?): Boolean {
        if (other !is Brawlers) return false
        return list == other.list
    }

    /**
     * Returns hash code of underlying [list] of brawlers.
     */
    override fun hashCode(): Int = list.hashCode()
}
