package com.lightningkite.kotlin.files

import java.io.File

/**
 * Returns a [File] which represents a child of the current directory.
 */
fun File.child(name: String): File {
    return File(this, name)
}