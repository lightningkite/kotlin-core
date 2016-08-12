package com.lightningkite.kotlin.math

/**
 * Various rounding functions
 * Created by joseph on 8/10/16.
 */

inline fun Float.round() = Math.round(this)

inline fun Double.round() = Math.round(this)
inline fun Double.roundTo(digit: Int): Double {
    val multiplier = 10.0.pow(-digit.toDouble())
    return this.times(multiplier).round().toDouble().div(multiplier)
}

inline fun Float.roundTo(digit: Int): Float {
    val multiplier = 10.0.pow(-digit.toDouble())
    return this.times(multiplier).round().toDouble().div(multiplier).toFloat()
}

fun main(vararg args: String) {
    println(23.5.roundTo(-1))
}