package com.lightningkite.kotlin.bytes

/**
 *
 * Created by shanethompson on 6/29/17.
 *
 */

class IntBitArray(var value: Int = 0) : Iterable<Boolean> {
    operator fun get(index: Int): Boolean {
        return value.ushr(index).and(0x1) == 1
    }

    operator fun set(index: Int, isTrue: Boolean) {
        if(isTrue) {
            value = value or 0x1.shl(index)
        } else {
            value = value.and(1.shl(index).inv())
        }
    }

    override fun iterator(): Iterator<Boolean> {
        return object : Iterator<Boolean> {
            var currentIndex = 0
            override fun hasNext(): Boolean {
                return currentIndex < 32
            }

            override fun next(): Boolean {
                val result = this@IntBitArray[currentIndex]
                currentIndex++
                return result
            }
        }
    }
}

fun Int.toBitArray(): IntBitArray {
    return IntBitArray(this)
}
