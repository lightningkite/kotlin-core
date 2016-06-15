package com.lightningkite.kotlin.collection

/**
 * Created by jivie on 5/6/16.
 */
class MappedMutableSet<S, E>(val source: MutableSet<S>, val mapper: (S) -> E, val reverseMapper: (E) -> S) : MutableSet<E> {
    override val size: Int get() = source.size
    override fun add(element: E): Boolean = source.add(reverseMapper(element))
    override fun addAll(elements: Collection<E>): Boolean = source.addAll(elements.map(reverseMapper))
    override fun clear() = source.clear()
    override fun iterator(): MutableIterator<E> = source.iterator().mapped(mapper, reverseMapper)
    override fun remove(element: E): Boolean = source.remove(reverseMapper(element))
    override fun removeAll(elements: Collection<E>): Boolean = source.removeAll(elements.map(reverseMapper))
    override fun retainAll(elements: Collection<E>): Boolean = source.retainAll(elements.map(reverseMapper))
    override fun contains(element: E): Boolean = source.contains(reverseMapper(element))
    override fun containsAll(elements: Collection<E>): Boolean = source.containsAll(elements.map(reverseMapper))
    override fun isEmpty(): Boolean = source.isEmpty()
}

fun <S, E> MutableSet<S>.mapped(mapper: (S) -> E, reverseMapper: (E) -> S): MutableSet<E> = MappedMutableSet(this, mapper, reverseMapper)
fun <S, E> MutableSet<S>.mapped(reverseMapper: (E) -> S): MutableSet<E> = MappedMutableSet(this, { throw IllegalAccessException() }, reverseMapper)