package com.lightningkite.kotlin.stream

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
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

fun InputStream.writeToFile(file: File) {
    val fos = FileOutputStream(file)
    try {
        val data = ByteArray(1024)
        var total: Long = 0
        while (true) {
            val count = this.read(data)
            if (count == -1) break
            total += count.toLong()
            fos.write(data, 0, count)
        }
        fos.flush()
    } finally {
        try {
            fos.close()
        } catch (e: Throwable) {/*squish*/
        }
        try {
            this.close()
        } catch (e: Throwable) {/*squish*/
        }
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