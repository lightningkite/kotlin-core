package com.lightningkite.kotlin.range

/**
 * Returns a random integer within the range.
 */
fun IntRange.random(): Int {
    return Math.random().times(last - first + 1).plus(first).toInt()
}

/**
 * Returns a random float within the range.
 */
fun ClosedRange<Float>.random(): Float {
    return Math.random().times(this.endInclusive - start).plus(start).toFloat()
}

/**
 * Returns a random double within the range.
 */
fun ClosedRange<Double>.random(): Double {
    return Math.random().times(this.endInclusive - start).plus(start)
}