package com.example.kotlinlib.kotlinbase.singleton

/**
 * 饿汉式  相当于Java static{instance = xxxx()} 直接初始化
 */
object Singleton1 {

    fun doSomething(): String {
        return "Singleton1 doSomething"
    }
}

fun main() {
    println(Singleton1.doSomething())
}