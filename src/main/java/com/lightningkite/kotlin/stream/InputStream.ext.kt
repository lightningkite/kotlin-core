package com.lightningkite.kotlin.stream

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.nio.charset.Charset

fun InputStream.toByteArray(): ByteArray {
    val output = ByteArrayOutputStream()
    try {
        val b = ByteArray(4096)
        var n = read(b)
        while (n != -1) {
            output.write(b, 0, n)
            n = read(b)
        }
        return output.toByteArray()
    } finally {
        output.close()
    }
}

fun InputStream.toString(charset: String): String {
    val output = ByteArrayOutputStream()
    try {
        val b = ByteArray(4096)
        var n = read(b)
        while (n != -1) {
            output.write(b, 0, n)
            n = read(b)
        }
        return output.toString(charset)
    } finally {
        output.close()
    }
}

fun InputStream.toString(charset: Charset): String {
    return toByteArray().toString(charset)
}