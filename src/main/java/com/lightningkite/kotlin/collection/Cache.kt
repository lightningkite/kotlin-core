package com.lightningkite.kotlin.collection

import java.util.*

/**
 * Created by josep on 2/12/2016.
 */
class Cache<K, V>(val map: MutableMap<K, V> = HashMap(), val generate: (K) -> V) : MutableMap<K, V> by map {
    override fun get(key: K): V {
        return map[key] ?: {
            val new = generate(key)
            map[key] = new
            new
        }()
    }
}