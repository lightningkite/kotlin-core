package com.lightningkite.kotlin.text

/**
 * Various extensions for String.
 * Created by jivie on 6/1/16.
 */


private val EmailRegularExpression: Regex = "[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?".toRegex(RegexOption.IGNORE_CASE)

fun String.isEmail(): Boolean {
    return matches(EmailRegularExpression)
}