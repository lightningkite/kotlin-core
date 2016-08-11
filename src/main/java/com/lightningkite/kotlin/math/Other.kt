package com.lightningkite.kotlin.math

/**
 * Created by joseph on 8/10/16.
 */

inline fun Double.pow(other: Double): Double {
    return Math.pow(this, other)
}

inline fun Int.pow(other: Int): Int {
    var total = 1
    for (i in 0 until other) {
        total *= other
    }
    return total
}

inline fun Long.pow(other: Long): Long {
    var total = 1L
    for (i in 0 until other) {
        total *= other
    }
    return total
}

/**
 * Similar to modulus, but works differently with negatives.
 */
inline fun Float.remainder(divisor: Float): Float {
    return this - Math.floor(this.toDouble() / divisor).toFloat() * divisor
}

/**
 * Similar to modulus, but works differently with negatives.
 */
inline fun Double.remainder(divisor: Double): Double {
    return this - Math.floor(this / divisor) * divisor
}