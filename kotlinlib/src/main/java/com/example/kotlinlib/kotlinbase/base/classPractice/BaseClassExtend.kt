package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * 超类定义扩展函数 全局都可以使用 如果和系统的扩展函数相同 则会覆盖系统的扩展函数，优先使用自定义的扩展函数
 * 还可以自定义泛型扩展类，任何的类型都是泛型 包括 函数类型
 */
fun Any.printContent() = run { println("printContent = $this") }

fun Any.printContent1(): Any {
    println("this is any print1 $this")
    return this
}

fun <T> T.showContentInfo() {
    if (this is String) {
        println("this is String type $this")
    } else {
        print("this is not String type $this")
    }
}

fun <I> I.showInput(): String {
    return when (this) {
        is String -> "this is String :$this"
        is Int -> "this is Int type $this"
        is Char -> "this is Char type $this"
        is Boolean -> "this is Boolean type $this"
        is Float -> "this is Float type $this"
        is Byte -> "this is Byte type $this"
        is Double -> "this is Double type $this"
        is Long -> "this is Long type $this"
        else -> "other type"
    }
}

fun commFun() {

}

fun main() {
    "A".printContent()
    "B".printContent1().printContent()

    "C".showContentInfo()
    1.showContentInfo()
    println()

    println("S".showInput())
    3.showInput().printContent()
    44.44444.showInput().printContent()
    'c'.showInput().printContent()
    true.showInput().printContent()
    22.1f.showInput().printContent()
    123L.showInput().printContent()
    1.toByte().showInput().printContent()
    commFun().showInput().printContent()

}