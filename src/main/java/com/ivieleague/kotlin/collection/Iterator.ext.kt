package com.ivieleague.kotlin.collection

/**
 * Created by jivie on 5/6/16.
 */
fun <S, T> MutableListIterator<S>.map(mapper: (S) -> T, reverseMapper: (T) -> S): MutableListIterator<T> {
    return object : MutableListIterator<T> {
        override fun hasPrevious(): Boolean = this@map.hasPrevious()
        override fun nextIndex(): Int = this@map.nextIndex()
        override fun previous(): T = mapper(this@map.previous())
        override fun previousIndex(): Int = this@map.previousIndex()
        override fun add(element: T) = this@map.add(reverseMapper(element))
        override fun hasNext(): Boolean = this@map.hasNext()
        override fun next(): T = mapper(this@map.next())
        override fun remove() = this@map.remove()
        override fun set(element: T) = this@map.set(reverseMapper(element))
    }
}

fun <S, T> MutableIterator<S>.map(mapper: (S) -> T, reverseMapper: (T) -> S): MutableIterator<T> {
    return object : MutableIterator<T> {
        override fun hasNext(): Boolean = this@map.hasNext()
        override fun next(): T = mapper(this@map.next())
        override fun remove() = this@map.remove()
    }
}

fun <S, T> Iterator<S>.map(mapper: (S) -> T): Iterator<T> {
    return object : Iterator<T> {
        override fun hasNext(): Boolean = this@map.hasNext()
        override fun next(): T = mapper(this@map.next())
    }
}