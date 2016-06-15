package com.lightningkite.kotlin.collection

/**
 * Created by jivie on 5/6/16.
 */
fun <S, T> MutableListIterator<S>.mapped(mapper: (S) -> T, reverseMapper: (T) -> S): MutableListIterator<T> {
    return object : MutableListIterator<T> {
        override fun hasPrevious(): Boolean = this@mapped.hasPrevious()
        override fun nextIndex(): Int = this@mapped.nextIndex()
        override fun previous(): T = mapper(this@mapped.previous())
        override fun previousIndex(): Int = this@mapped.previousIndex()
        override fun add(element: T) = this@mapped.add(reverseMapper(element))
        override fun hasNext(): Boolean = this@mapped.hasNext()
        override fun next(): T = mapper(this@mapped.next())
        override fun remove() = this@mapped.remove()
        override fun set(element: T) = this@mapped.set(reverseMapper(element))
    }
}

fun <S, T> MutableIterator<S>.mapped(mapper: (S) -> T, reverseMapper: (T) -> S): MutableIterator<T> {
    return object : MutableIterator<T> {
        override fun hasNext(): Boolean = this@mapped.hasNext()
        override fun next(): T = mapper(this@mapped.next())
        override fun remove() = this@mapped.remove()
    }
}

fun <S, T> Iterator<S>.mapped(mapper: (S) -> T): Iterator<T> {
    return object : Iterator<T> {
        override fun hasNext(): Boolean = this@mapped.hasNext()
        override fun next(): T = mapper(this@mapped.next())
    }
}

fun <S, T> ListIterator<S>.mapped(mapper: (S) -> T): ListIterator<T> {
    return object : ListIterator<T> {
        override fun hasPrevious(): Boolean = this@mapped.hasPrevious()
        override fun nextIndex(): Int = this@mapped.nextIndex()
        override fun previous(): T = mapper(this@mapped.previous())
        override fun previousIndex(): Int = this@mapped.previousIndex()
        override fun hasNext(): Boolean = this@mapped.hasNext()
        override fun next(): T = mapper(this@mapped.next())
    }
}