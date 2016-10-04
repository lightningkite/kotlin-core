package com.lightningkite.kotlin.collection

/**
 * Created by jivie on 5/6/16.
 */
fun <S, T> MutableListIterator<S>.mapping(mapper: (S) -> T, reverseMapper: (T) -> S): MutableListIterator<T> {
    return object : MutableListIterator<T> {
        override fun hasPrevious(): Boolean = this@mapping.hasPrevious()
        override fun nextIndex(): Int = this@mapping.nextIndex()
        override fun previous(): T = mapper(this@mapping.previous())
        override fun previousIndex(): Int = this@mapping.previousIndex()
        override fun add(element: T) = this@mapping.add(reverseMapper(element))
        override fun hasNext(): Boolean = this@mapping.hasNext()
        override fun next(): T = mapper(this@mapping.next())
        override fun remove() = this@mapping.remove()
        override fun set(element: T) = this@mapping.set(reverseMapper(element))
    }
}

fun <S, T> MutableIterator<S>.mapping(mapper: (S) -> T, reverseMapper: (T) -> S): MutableIterator<T> {
    return object : MutableIterator<T> {
        override fun hasNext(): Boolean = this@mapping.hasNext()
        override fun next(): T = mapper(this@mapping.next())
        override fun remove() = this@mapping.remove()
    }
}

fun <S, T> Iterator<S>.mapping(mapper: (S) -> T): Iterator<T> {
    return object : Iterator<T> {
        override fun hasNext(): Boolean = this@mapping.hasNext()
        override fun next(): T = mapper(this@mapping.next())
    }
}

fun <S, T> ListIterator<S>.mapping(mapper: (S) -> T): ListIterator<T> {
    return object : ListIterator<T> {
        override fun hasPrevious(): Boolean = this@mapping.hasPrevious()
        override fun nextIndex(): Int = this@mapping.nextIndex()
        override fun previous(): T = mapper(this@mapping.previous())
        override fun previousIndex(): Int = this@mapping.previousIndex()
        override fun hasNext(): Boolean = this@mapping.hasNext()
        override fun next(): T = mapper(this@mapping.next())
    }
}