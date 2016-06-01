package com.ivieleague.kotlin.text

/**
 * Various extensions for String.
 * Created by jivie on 6/1/16.
 */


val EmailRegularExpression: Regex = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}".toRegex(RegexOption.IGNORE_CASE)

inline fun String.isEmail(): Boolean {
    return matches(EmailRegularExpression)
}

fun String.toFloatMaybe(): Float? {
    try {
        return toFloat()
    } catch(e: NumberFormatException) {
        return null
    }
}

fun String.toDoubleMaybe(): Double? {
    try {
        return toDouble()
    } catch(e: NumberFormatException) {
        return null
    }
}

fun String.toIntMaybe(): Int? {
    try {
        return toInt()
    } catch(e: NumberFormatException) {
        return null
    }
}

fun String.toLongMaybe(): Long? {
    try {
        return toLong()
    } catch(e: NumberFormatException) {
        return null
    }
}

fun String.toFloatMaybe(default: Float): Float {
    try {
        return toFloat()
    } catch(e: NumberFormatException) {
        return default
    }
}

fun String.toDoubleMaybe(default: Double): Double {
    try {
        return toDouble()
    } catch(e: NumberFormatException) {
        return default
    }
}

fun String.toIntMaybe(default: Int): Int {
    try {
        return toInt()
    } catch(e: NumberFormatException) {
        return default
    }
}

fun String.toLongMaybe(default: Long): Long {
    try {
        return toLong()
    } catch(e: NumberFormatException) {
        return default
    }
}