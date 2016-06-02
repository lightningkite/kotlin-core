package com.ivieleague.kotlin.files

import java.io.File

/**
 * Created by jivie on 6/2/16.
 */
fun File.child(name: String): File {
    return File(this, name)
}