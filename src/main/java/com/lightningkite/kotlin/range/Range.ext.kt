package com.lightningkite.kotlin.range

/**
 * Various functions for dealing with ranges
 * Created by josep on 5/31/2016.
 */

fun IntRange.random(): Int {
    return Math.random().times(last - first + 1).plus(first).toInt()
}

fun ClosedRange<Float>.random(): Float {
    return Math.random().times(this.endInclusive - start).plus(start).toFloat()
}

fun ClosedRange<Double>.random(): Double {
    return Math.random().times(this.endInclusive - start).plus(start)
}