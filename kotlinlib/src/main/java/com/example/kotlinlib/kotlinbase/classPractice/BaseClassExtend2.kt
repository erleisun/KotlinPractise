package com.example.kotlinlib.kotlinbase.classPractice

import com.example.kotlinlib.kotlinbase.extend.random
import com.example.kotlinlib.kotlinbase.extend.random1

/**
 *自定义一个泛型扩展函数
 */

fun main() {
    val listOf = listOf("1", "2", "3", "4")
    val setOf = setOf(1, 2, 3, 4, 5)

    listOf.shuffled().first()
    setOf.shuffled().first()

    println()

    println(listOf.random())
    println(setOf.shuffled().random1())
}