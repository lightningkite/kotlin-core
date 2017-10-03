package com.lightningkite.kotlin.text

/**
 * Various extensions for String.
 * Created by jivie on 6/1/16.
 */


val EmailRegularExpression: Regex = "[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?".toRegex(RegexOption.IGNORE_CASE)

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

fun String.toByte(radix: Int): Byte {
    return java.lang.Byte.parseByte(this, radix)
}

fun String.toShort(radix: Int): Short {
    return java.lang.Short.parseShort(this, radix)
}

fun String.toInt(radix: Int): Int {
    return java.lang.Integer.parseInt(this, radix)
}

fun String.toLong(radix: Int): Long {
    return java.lang.Long.parseLong(this, radix)
}