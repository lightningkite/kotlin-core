package com.lightningkite.kotlin.stream

import java.io.InputStream
import java.nio.charset.Charset

/**
 * Reads all of the input stream into a byte array and closes it.
 */
fun InputStream.toByteArray(estimatedSize: Int = DEFAULT_BUFFER_SIZE): ByteArray = use {
    this.readBytes(estimatedSize)
}

/**
 * Reads all of the input stream into a string and closes it.
 */
fun InputStream.toString(estimatedSize: Int = DEFAULT_BUFFER_SIZE, charset: Charset = Charsets.UTF_8): String = use {
    this.reader(charset).readText()
}