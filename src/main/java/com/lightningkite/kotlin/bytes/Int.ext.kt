package com.lightningkite.kotlin.bytes

/**
 * A mutable container for an integer that allows access to individual bits.
 * Created by shanethompson on 6/29/17.
 */
class IntBitArray(var value: Int = 0) : Iterable<Boolean> {

    /**
     * Gets whether or not the bit at [index] is on.
     * Index starts with the right-most bit at zero and increases going left.
     */
    operator fun get(index: Int): Boolean {
        return value.ushr(index).and(0x1) == 1
    }

    /**
     * Sets whether or not the bit at [index] is on.
     * Index starts with the right-most bit at zero and increases going left.
     */
    operator fun set(index: Int, isTrue: Boolean) {
        if(isTrue) {
            value = value or 0x1.shl(index)
        } else {
            value = value.and(1.shl(index).inv())
        }
    }

    /**
     * Allows you to iterate through all 32 bits from right-most to left-most.
     */
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

/**
 * Creates a [IntBitArray] that represents the given integer, allowing for easy access of individual bits.
 */
fun Int.toBitArray(): IntBitArray {
    return IntBitArray(this)
}
