package com.lightningkite.kotlin.math

/**
 * Various math functions.
 * Created by jivie on 9/28/15.
 */

/**
 * Degrees from this angle (in degrees) to another angle (in degrees).
 */
fun Float.degreesTo(to: Float): Float {
    return ((to - this + 180).remainder(360f)) - 180
}

/**
 * Radians from this angle (in radians) to another angle (in radians).
 */
fun Float.radiansTo(to: Float): Float {
    return (((to - this + Math.PI).remainder(Math.PI * 2)) - Math.PI).toFloat()
}

/**
 * Degrees from this angle (in degrees) to another angle (in degrees).
 */
fun Double.degreesTo(to: Double): Double {
    return ((to - this + 180).remainder(360.0)) - 180
}

/**
 * Radians from this angle (in radians) to another angle (in radians).
 */
fun Double.radiansTo(to: Double): Double {
    return ((to - this + Math.PI).remainder(Math.PI * 2)) - Math.PI
}

/**
 * Similar to modulus, but works differently with negatives.
 */
fun Float.remainder(divisor: Float): Float {
    return this - Math.floor(this.toDouble() / divisor).toFloat() * divisor
}

/**
 * Similar to modulus, but works differently with negatives.
 */
fun Double.remainder(divisor: Double): Double {
    return this - Math.floor(this / divisor) * divisor
}