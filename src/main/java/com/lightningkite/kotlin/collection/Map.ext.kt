package com.lightningkite.kotlin.collection

/**
 * Created by josep on 8/13/2016.
 */
inline fun <K, V> MutableMap<K, V>.getOrMake(key: K, make: () -> V): V {
    val result: V? = get(key)
    if (result != null) return result
    val new = make()
    put(key, new)
    return new
}