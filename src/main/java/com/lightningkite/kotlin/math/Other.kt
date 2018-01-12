package com.lightningkite.kotlin.math

/*
 * Copyright 2015 Michael Rozumyanskiy
 * Modified by Joseph Ivie (2018)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

fun Double.sin(): Double = Math.sin(this)
fun Double.cos(): Double = Math.cos(this)
fun Double.tan(): Double = Math.tan(this)
fun Double.asin(): Double = Math.asin(this)
fun Double.acos(): Double = Math.acos(this)
fun Double.atan(): Double = Math.atan(this)
fun Double.toRadians(): Double = Math.toRadians(this)
fun Double.toDegrees(): Double = Math.toDegrees(this)
fun Double.exp(): Double = Math.exp(this)
fun Double.log(): Double = Math.log(this)
fun Double.log10(): Double = Math.log10(this)
fun Double.sqrt(): Double = Math.sqrt(this)
fun Double.cbrt(): Double = Math.cbrt(this)
fun Double.ceil(): Double = Math.ceil(this)
fun Double.floor(): Double = Math.floor(this)
fun Double.rint(): Double = Math.rint(this)
fun Double.abs(): Double = Math.abs(this)
fun Double.ulp(): Double = Math.ulp(this)
fun Double.signum(): Double = Math.signum(this)
fun Double.sinh(): Double = Math.sinh(this)
fun Double.cosh(): Double = Math.cosh(this)
fun Double.tanh(): Double = Math.tanh(this)
fun Double.expm1(): Double = Math.expm1(this)
fun Double.log1p(): Double = Math.log1p(this)
fun Double.exponent(): Int = Math.getExponent(this)
fun Double.nextUp(): Double = Math.nextUp(this)
fun Double.round(): Long = Math.round(this)

infix fun Double.IEEEremainder(divisor: Double): Double = Math.IEEEremainder(this, divisor)
infix fun Double.pow(exp: Double): Double = Math.pow(this, exp)
infix fun Double.copySign(sign: Double): Double = Math.copySign(this, sign)
infix fun Double.next(direction: Double): Double = Math.nextAfter(this, direction)
infix fun Double.scalb(scaleFactor: Int): Double = Math.scalb(this, scaleFactor)
infix fun Double.roundTo(digit: Int): Double {
    val multiplier = 10.0.pow(-digit.toDouble())
    return this.times(multiplier).round().toDouble().div(multiplier)
}


fun Float.sin(): Float = Math.sin(this.toDouble()).toFloat()
fun Float.cos(): Float = Math.cos(this.toDouble()).toFloat()
fun Float.tan(): Float = Math.tan(this.toDouble()).toFloat()
fun Float.asin(): Float = Math.asin(this.toDouble()).toFloat()
fun Float.acos(): Float = Math.acos(this.toDouble()).toFloat()
fun Float.atan(): Float = Math.atan(this.toDouble()).toFloat()
fun Float.toRadians(): Float = Math.toRadians(this.toDouble()).toFloat()
fun Float.toDegrees(): Float = Math.toDegrees(this.toDouble()).toFloat()
fun Float.exp(): Float = Math.exp(this.toDouble()).toFloat()
fun Float.log(): Float = Math.log(this.toDouble()).toFloat()
fun Float.log10(): Float = Math.log10(this.toDouble()).toFloat()
fun Float.sqrt(): Float = Math.sqrt(this.toDouble()).toFloat()
fun Float.cbrt(): Float = Math.cbrt(this.toDouble()).toFloat()
fun Float.ceil(): Float = Math.ceil(this.toDouble()).toFloat()
fun Float.floor(): Float = Math.floor(this.toDouble()).toFloat()
fun Float.rint(): Float = Math.rint(this.toDouble()).toFloat()
fun Float.abs(): Float = Math.abs(this)
fun Float.ulp(): Float = Math.ulp(this)
fun Float.signum(): Float = Math.signum(this)
fun Float.sinh(): Float = Math.sinh(this.toDouble()).toFloat()
fun Float.cosh(): Float = Math.cosh(this.toDouble()).toFloat()
fun Float.tanh(): Float = Math.tanh(this.toDouble()).toFloat()
fun Float.expm1(): Float = Math.expm1(this.toDouble()).toFloat()
fun Float.log1p(): Float = Math.log1p(this.toDouble()).toFloat()
fun Float.exponent(): Int = Math.getExponent(this)
fun Float.nextUp(): Float = Math.nextUp(this)
fun Float.round(): Int = Math.round(this)

infix fun Float.IEEEremainder(divisor: Float): Float = Math.IEEEremainder(this.toDouble(), divisor.toDouble()).toFloat()
infix fun Float.pow(exp: Float): Float = Math.pow(this.toDouble(), exp.toDouble()).toFloat()
infix fun Float.copySign(sign: Float): Float = Math.copySign(this, sign)
infix fun Float.next(direction: Float): Float = Math.nextAfter(this, direction.toDouble())
infix fun Float.scalb(scaleFactor: Int): Float = Math.scalb(this, scaleFactor)
infix fun Float.roundTo(digit: Int): Float {
    val multiplier = 10.0.pow(-digit.toDouble())
    return this.times(multiplier).round().toDouble().div(multiplier).toFloat()
}