package com.lightningkite.kotlin.bytes

/**
 * Created by josep on 8/13/2016.
 */
val hexArray = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

inline fun ByteArray.toStringHex(): String {
    val hexChars = CharArray(size * 2)
    var index = 0
    for (byte in this) {
        val ubyte = (byte.toInt() and 0xFF)
        hexChars[index * 2] = hexArray[ubyte ushr 4]
        hexChars[index * 2 + 1] = hexArray[ubyte and 0x0F]
        index++
    }
    return String(hexChars)
}

inline fun String.hexToByteArray(): ByteArray {
    val array = ByteArray(length / 2)
    for (i in array.indices) {
        array[i] = ((this[i * 2].toHexValue() shl 4) or (this[i * 2 + 1].toHexValue())).toByte()
    }
    return array
}

inline fun Char.toHexValue(): Int {
    return if (this >= 'a') {
        this - 'a' + 10
    } else if (this >= 'A')
        this - 'A' + 10
    else
        this - '0'
}