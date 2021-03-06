#!/usr/bin/env kotlin

open class Foo {
    private fun foo(name: String){
        println("foo: $name")
    }

    protected fun baz(name: String) {
        println("baz: $name")
    }

    fun bar(name: String) {
        println("bar: $name")
    }
}

val foo = Foo()
Foo::class.java.declaredMethods.forEach { method ->
    try {
        method.isAccessible = true
        println(method.name.toUpperCase())
        method(foo, null)
    } catch (exception: Throwable) {
        println(exception.cause)
    }
    println("==========")
}





