package com.example.kotlinlib.kotlinbase.classPractice

/**
 * infix 关键字
 */
class BaseClassInfix {
}

private infix fun <C1, C2> C1.gogogo(a: C2) {
    println("C2 = $a this is $this")
}

fun main() {

    val some = "some"
    some.gogogo(5)
    //中序表达式 可以不需要括号和.
    some gogogo 6

}