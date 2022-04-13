package com.example.kotlinlib.kotlinbase.base.operation

import java.io.File

/**
 * 高级运算符apply匿名函数 持有 this，总是返回自己
 * let匿名函数持有 it，最后一行作为返回值， 可以为很多类型
 * run匿名函数持有this，并返回最后后一行类型 可以连续调用 run 转为不同的类型 多级调用
 * with 和run 基本一样 只是使用的时候有点不同
 * also 匿名函数持有it 总是返回自己本身 和apply一样
 * takeIf  匿名函数接受ture/false 如果为true 返回本身  否则返回null  一般和空合并操作符一起使用
 * takeUnless  和takeIf功能是相反的
 */

fun main() {

    var str = "Hello ESun"
    //apply 总是返回自身
    val applyStr = str.apply {
        toLowerCase()
    }
    println("applyStr = $applyStr")

    var file = File("D:\\text.txt")
//    file.setExecutable(true)
//    file.setReadable(true)
//    println("readLine = ${file.readLines()}")

    file.apply {
        setExecutable(true)
        setReadable(true)
    }.apply {
        println("${file.readLines()}")
    }

    //匿名函数的最后一行作为返回值
    val let = listOf<Int>(1, 2, 3, 4, 5).let {
        it.first() + it.first()
    }
    println("let = $let")

    println("return ${method(null)}")

    runTest("123")

    with(str, ::print)
    val with1 = with(str) {
        println("str is $str")
        "hello,who are you"
    }.let {
        it.length
    }
    println("with1 = $with1")

    //引用 it 返回this
    str.also {
    }

    takeIfTest()
}

/**
 * 可以使用let 与合并操作符 返回特定的值
 */
fun method(value: String?): String {
    return value?.let {
        "this is $value"
    } ?: "value is null"
}

/**
 * run 引用this类型 然后返回最后一行的类型 可以给下一个run使用
 */
fun runTest(str: String) {
    str.run {
        str.toIntOrNull()
    }.run {
        println("last is $this")
    }
}

fun takeIfTest() {
    println("result is ${checkPermission("ESun", "pwd")}")
}

/**
 * 如果true 返回name本身 否则返回 xxx
 */
fun checkPermission(name: String, pwd: String): String {
    return name.takeIf {
        "Root" == name && "pwd" == pwd
    } ?: "name or pwd error!"
}

class AdvanceOperation {
}