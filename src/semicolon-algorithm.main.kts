#!/usr/bin/env kotlin
val Long.readableSize: String
    get() = longArrayOf(1024, 1024, 1024, 1024).scan(1L) { acc, ele ->
        acc * ele
    }.zip(arrayOf("B", "KB", "MB", "GB")).foldRight("") { (size, unit), previous ->
        ((this / size) % 1024).let {
            previous + if (it >= 1) " $it$unit" else ""
        }
    }

println(1023L.readableSize)
println(1024L.readableSize)
println((1023L * 1024).readableSize)
println((1023L * 1024 * 1024 + 300 * 1024 + 50).readableSize)


val units = arrayOf("B", "KB", "MB", "GB").zip(longArrayOf(1024, 1024, 1024, 1024).scan(1L) { acc, ele ->
    acc * ele
}).toMap()


val String.computableSize: Long
    get() = split("""\s+""".toRegex()).fold(0) { acc, ele ->
        ("""(\d+)(\w+)""".toRegex().matchEntire(ele)?.groupValues?.let { (_, size, unit) ->
            (units[unit] ?: 0) * size.toLong()
        } ?: 0)
            + acc.also { println(it) }
    }

println("1023MB 300KB 50B".computableSize)





