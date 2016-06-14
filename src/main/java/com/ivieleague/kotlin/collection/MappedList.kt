package com.ivieleague.kotlin.collection

/**
 * Created by jivie on 6/14/16.
 */
class MappedList<S, T>(val around: List<S>, val mapper: (S) -> T, val reverseMapper: (T) -> S) : List<T> {
    override fun contains(element: T): Boolean = around.contains(reverseMapper(element))
    override fun containsAll(elements: Collection<T>): Boolean = around.containsAll(elements.map(reverseMapper))
    override fun get(index: Int): T = mapper(around.get(index))
    override fun indexOf(element: T): Int = around.indexOf(reverseMapper(element))
    override fun isEmpty(): Boolean = around.isEmpty()
    override fun iterator(): Iterator<T> = around.iterator().mapped(mapper)
    override fun lastIndexOf(element: T): Int = around.lastIndexOf(reverseMapper(element))
    override fun listIterator(): ListIterator<T> = around.listIterator().mapped(mapper)
    override fun listIterator(index: Int): ListIterator<T> = around.listIterator(index).mapped(mapper)
    override fun subList(fromIndex: Int, toIndex: Int): List<T> = around.subList(fromIndex, toIndex).mapped(mapper, reverseMapper)
    override val size: Int get() = around.size

}

fun <S, T> List<S>.mapped(mapper: (S) -> T, reverseMapper: (T) -> S): List<T> = MappedList(this, mapper, reverseMapper)