#!/usr/bin/env kotlin
val Long.readableSize: String
    get() = if (this < 1024) {
        "$this"
    } else if (this < 1024 * 1024) {
        "${(this / 1024).toInt()}K"
    } else if (this < 1024 * 1024 * 1024) {
        "${(this / (1024 * 1024)).toInt()}M"
    } else {
        "${this / (1024 * 1024 * 1024)}G"
    }.let { "trash: ${it}B" }


longArrayOf(
    999,
    99 * 1024,
    99 * 1024 * 1024,
    99L * 1024 * 1024 * 1024
).forEach {
    println(it.readableSize)
}



