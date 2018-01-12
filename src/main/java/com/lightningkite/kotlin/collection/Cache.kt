package com.lightningkite.kotlin.collection

import java.util.*

/**
 * A [MutableMap] that always returns a value, where when one value has no entry, it is generated using [generate].
 *
 * Created by josep on 2/12/2016.
 */
open class Cache<K, V>(val map: MutableMap<K, V> = HashMap(), val generate: (K) -> V) : MutableMap<K, V> by map {
    override fun get(key: K): V {
        return map[key] ?: generate(key).apply {
            map[key] = this
        }
    }
}