#!/usr/bin/env kotlin
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

import kotlinx.coroutines.flow.*

fun String.eliminateUnknownLiteral(next: String) =
        listOf(this, next).joinToString { it.replace("""(?i)Unknown""".toRegex(), "") }

fun main(args: Array<String>) {
    val tracks = flow<String> {}
    val invalidateHints = flow<String> {}
    combine(tracks, invalidateHints, String::eliminateUnknownLiteral)


