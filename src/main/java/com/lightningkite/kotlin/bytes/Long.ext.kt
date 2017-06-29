package com.lightningkite.kotlin.bytes

/**
 *
 * Created by shanethompson on 6/29/17.
 *
 */


class LongBitArray(var value: Long = 0) : Iterable<Boolean> {
    operator fun get(index: Int): Boolean {
        return value.ushr(index).and(0x1) == 1L
    }

    operator fun set(index: Int, isTrue: Boolean) {
        if(isTrue) {
            value = value or 0x1.shl(index).toLong()
        } else {
            value = value.and(1.shl(index).inv().toLong())
        }
    }

    override fun iterator(): Iterator<Boolean> {
        return object : Iterator<Boolean> {
            var currentIndex = 0
            override fun hasNext(): Boolean {
                return currentIndex < 64
            }

            override fun next(): Boolean {
                val result = this@LongBitArray[currentIndex]
                currentIndex++
                return result
            }
        }
    }
}

fun Long.toBitArray(): LongBitArray {
    return LongBitArray(this)
}