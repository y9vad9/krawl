package com.y9vad9.brawlstars.pagination

import com.y9vad9.brawlstars.types.value.Count
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Interface representing a page iterator for paginated data retrieval.
 *
 * @param T The type of elements in the page.
 */
public interface PagesIterator<T> {
    public val pageSize: Count

    /**
     * Returns `true` if there is another page available, `false` otherwise.
     *
     * **Note**: Even if iterator returns true, it doesn't necessary means that
     * there should be new elements. It effectively means that we should query next page (using next)
     * and check whether there are new elements.
     *
     * @return `true` if there is another page, `false` otherwise.
     */
    public operator fun hasNext(): Boolean


    /**
     * Returns `true` if there is previous page available in the context.
     */
    public fun hasPrevious(): Boolean

    /**
     * Returns the next page of elements.
     *
     * @return The list of elements in the next page.
     * @throws NoSuchElementException if there are no more pages available.
     */
    @Throws(NoSuchElementException::class)
    public suspend operator fun next(): Result<List<T>>

    /**
     * Returns the previous page of elements.
     *
     * @return The list of elements in the next page.
     * @throws NoSuchElementException if there are no more pages available.
     */
    @Throws(NoSuchElementException::class)
    public suspend fun previous(): Result<List<T>>

    /**
     * Returns an iterator over the pages.
     *
     * @return The iterator itself.
     */
    public operator fun iterator(): PagesIterator<T> = this
}

/**
 * Converts the [PagesIterator] into a [Flow] of lists of elements.
 *
 * @return A [Flow] that emits lists of elements from the page iterator.
 */
public fun <T> PagesIterator<T>.asFlow(): Flow<List<T>> = flow {
    for (elements in this@asFlow)
        emit(elements.getOrThrow())
}

/**
 * Performs the given [block] on each page of elements from the [PagesIterator].
 *
 * @param block The block to be executed on each page of elements.
 */
public suspend inline fun <T> PagesIterator<T>.forEachPage(block: (Result<List<T>>) -> Unit) {
    while (hasNext()) {
        block(next())
    }
}

/**
 * Applies a transformation to the elements of the current [PagesIterator].
 *
 * @param mapper The mapping function that takes an element of type [T] and returns a new element of type [R].
 * @return A new [PagesIterator] that represents the result of applying the given [mapper] function to each element of the original iterator.
 */
public fun <T, R> PagesIterator<T>.map(mapper: suspend (T) -> R): PagesIterator<R> {
    return MappingPagesIterator(this, mapper)
}

public fun <T> PagesIterator(
    limit: Count,
    provider: suspend (limit: Count, cursors: Cursors?) -> Result<Page<T>>,
): PagesIterator<T> = PagesIteratorImpl(provider = provider, pageSize = limit)

private class PagesIteratorImpl<T>(
    private val provider: suspend (limit: Count, cursors: Cursors?) -> Result<Page<T>>,
    override val pageSize: Count,
    private var lastCursors: Cursors? = null,
) : PagesIterator<T> {
    /**
     * Enum representing the state of the page iterator.
     *
     * - **DONE** – no more elements present.
     * - **UNKNOWN** – initial state of the iterator, needs to be queried first.
     * - **READY** – has more elements to consume (it's sdk-side decision, so there's possibility that
     * next page has no elements at all).
     */
    private enum class State {
        UNKNOWN, READY, DONE,
    }

    private var nextState: State = State.UNKNOWN
    private var prevState: State = State.DONE

    override fun hasNext(): Boolean {
        return nextState != State.DONE
    }

    override fun hasPrevious(): Boolean {
        return prevState != State.DONE
    }

    override suspend fun next(): Result<List<T>> {
        return provider(pageSize, Cursors(after = lastCursors?.after, before = null)).map { page ->
            lastCursors = page.paging
                .also { nextState = if (it?.after == null) State.DONE else State.READY }
            page.items ?: emptyList()
        }
    }

    override suspend fun previous(): Result<List<T>> {
        return provider(pageSize, Cursors(before = lastCursors?.before, after = null)).map { page ->
            lastCursors = page.paging.also { prevState = if (it?.before == null) State.DONE else State.READY }
            page.items ?: emptyList()
        }
    }
}

@PublishedApi
internal class MappingPagesIterator<T, R>(
    private val source: PagesIterator<T>,
    private val mapper: suspend (T) -> R,
) : PagesIterator<R> {
    override fun hasNext(): Boolean = source.hasNext()
    override fun hasPrevious(): Boolean = source.hasPrevious()

    override val pageSize: Count
        get() = source.pageSize

    override suspend fun next(): Result<List<R>> {
        return source.next().map {
            it.map { item -> mapper(item) }
        }
    }

    override suspend fun previous(): Result<List<R>> = source.previous().map { list ->
        list.map { mapper(it) }
    }
}