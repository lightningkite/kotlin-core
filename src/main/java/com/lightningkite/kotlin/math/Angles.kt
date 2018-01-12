package com.lightningkite.kotlin.math

/**
 * Various math functions.
 * Created by jivie on 9/28/15.
 */

/**
 * Degrees from this angle (in degrees) to another angle (in degrees).
 */
infix fun Float.degreesTo(to: Float): Float {
    return ((to - this + 180).rem(360f)) - 180
}

/**
 * Radians from this angle (in radians) to another angle (in radians).
 */
infix fun Float.radiansTo(to: Float): Float {
    return (((to - this + Math.PI).rem(Math.PI * 2)) - Math.PI).toFloat()
}

/**
 * Degrees from this angle (in degrees) to another angle (in degrees).
 */
infix fun Double.degreesTo(to: Double): Double {
    return ((to - this + 180).rem(360.0)) - 180
}

/**
 * Radians from this angle (in radians) to another angle (in radians).
 */
infix fun Double.radiansTo(to: Double): Double {
    return ((to - this + Math.PI).rem(Math.PI * 2)) - Math.PI
}