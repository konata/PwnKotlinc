#!/usr/bin/env kotlin
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers.Unconfined
import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.startCoroutine

operator fun Regex.contains(text: CharSequence) = containsMatchIn(text)
object DidNotRespondsToException : RuntimeException()
fun respond(to: String) = when (to) {
    in """.*吗\??$""".toRegex() -> to.replace("""吗\??$""".toRegex(), "").replace("我", "你")
    else -> throw DidNotRespondsToException
}

suspend {
    println("Chatting On ${SimpleDateFormat("MM-dd").format(Date())}")
    try {
        suspendCoroutineUninterceptedOrReturn<Unit> {
            val statement = listOf("在吗?", "下班了吗?", "我今天好看吗?" , "今天是妇女节", "我想买包包")
            statement.forEach {
                println(it to respond(it))
            }
            COROUTINE_SUSPENDED
        }
    } finally {
        println("FIN")
    }
}.startCoroutine(object : Continuation<Unit> {
    override val context: CoroutineContext = Unconfined + CoroutineName("chatting bot")
    override fun resumeWith(result: Result<Unit>) {
        println("886")
    }
})







