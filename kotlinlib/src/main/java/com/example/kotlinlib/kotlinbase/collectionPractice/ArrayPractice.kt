package com.example.kotlinlib.kotlinbase.collectionPractice

import java.io.File

/**
 * 数组练习
 *  IntArray    IntArrayOf
LongArray
DoubleArray
ShortArray
ByteArray
FloatArray
BooleanArray
CharArray
Array         arrayOf 对象数组
 */
fun main() {
    //数组类型
    val intArrayOf = intArrayOf(1, 2, 3, 4, 5)
    println(intArrayOf[0])
    println(intArrayOf[1])
    println(intArrayOf[2])
    //数组转list
    intArrayOf.toMutableList()
    //为空时 如果val未指定类型可以返回任意对象
    val i = intArrayOf.elementAtOrNull(6) ?: -1
    println(i)
    val orElse = intArrayOf.elementAtOrElse(6) { -1 }
    println(orElse)

    val arrayOf: Array<String> = arrayOf("11", "22", "33")
    val obeArray: Array<File> = arrayOf<File>(File("a"), File("b"))
}


class ArrayPractice {
}