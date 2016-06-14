package com.ivieleague.kotlin.collection

/**
 * Various extensions functions for lists.
 * Created by jivie on 4/26/16.
 */

inline fun <E> List<E>.random(): E {
    return this[Math.random().times(size).toInt()]
}

fun <E> MutableList<E>.addSorted(item: E, compare: (E, E) -> Boolean): Int {
    var index = 0
    for (it in this) {
        if (compare(item, it)) {
            break
        }
        index++
    }
    add(index, item)
    return index
}

fun <E : Comparable<E>> MutableList<E>.addSorted(item: E): Int {
    var index = 0
    for (it in this) {
        if (item.compareTo(it) < 0) {
            break
        }
        index++
    }
    add(index, item)
    return index
}

inline fun <E : Comparable<E>> MutableList<E>.addSortedReverse(item: E): Int {
    var index = 0
    for (it in this) {
        if (item.compareTo(it) > 0) {
            break
        }
        index++
    }
    add(index, item)
    return index
}