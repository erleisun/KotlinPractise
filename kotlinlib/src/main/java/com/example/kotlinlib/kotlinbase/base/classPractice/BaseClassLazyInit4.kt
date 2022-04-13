package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * KT
 */
class BaseClassLazyInit4(_name: String) {

    init {
    }
    //var p: String = getResponse() //调用主构造函数时即会初始化p  并调用函数执行，没有延迟初始化
    val p: String by lazy { getResponse() } //延迟加载 只有使用到P时 才会调用函数执行

    private fun getResponse(): String {
        println("loading...")
        return "you are good"
    }
}

fun main() {
    val baseClassLateInit4 = BaseClassLazyInit4(_name = "tom")
    Thread.sleep(3000)
//    println("get p = ${baseClassLateInit4.p}")
    println("get p = ${baseClassLateInit4.p}")
}