package com.example.kotlinlib.kotlinbase.base

import kotlin.math.roundToInt

/**
 * String 相关基础操作
 */
fun main() {
    var str: String = "hello,nice to meeting you！ "
    //统计字符个数
    str.count()
    //统计c字符个数
    str.count { ch ->
        ch == 'c'
    }
    //首字母变大写
    str.capitalize()
    //是否空格
    str.isBlank()
    //为空时抛异常
    checkNotNull(str)
    requireNotNull(str)

    //字符串截取
    val indexOf = str.indexOf("n")
    str.substring(0, indexOf)
    str.substring(0 until indexOf) //kt 一般用until

    //split 分割操作 返回一个list集合
    val splitList = str.split(",")
    //如果明确是两个结果 可以使用解构直接赋值
    val (v1, v2) = splitList
    println("解构 v1 = $v1 v2 = $v2")

    //replace 操作
    str.replace("A", "B")
    str.replace(Regex("[ABC]")) {
        when (it.value) {
            "A" -> "9"
            else -> "0"
        }
    }

    // == 和===
    //== 值比较  和java equals。 ===是引用的比较
    val str2 = "ESun"
    val str1 = "ESun"
    println(str1 == str2)
    println(str1 === str2)

    //字符串遍历操作
    str1.forEach {
        print("$it")
    }

    //数字类型安全转换 尽量使用toIntOrNull 防止crash
    val num = "666"
    num.toInt()
    val num1 = "666.1".toIntOrNull()
    //double转int roundToInt
    println(1111.611.toInt())
    println(1111.461.toInt())//四舍五入
    println(1111.561.roundToInt())//保证double有四舍五入的效果

    //保留多个小数点  是一个字符串操作，返回的还是字符串
    val r: String = "%.3f".format(111.123456)
    println("r = $r")
}

class BaseString {


}