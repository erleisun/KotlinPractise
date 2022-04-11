package com.example.kotlinlib.kotlinbase.singleton

/**
 * 饿汉式  双重检查
 */
class Singleton3 private constructor() {

    companion object {
        val mInstance: Singleton3 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Singleton3()
        }
    }

    fun doSomething() {
    }
}

fun main() {

    Singleton3.mInstance.doSomething()
}