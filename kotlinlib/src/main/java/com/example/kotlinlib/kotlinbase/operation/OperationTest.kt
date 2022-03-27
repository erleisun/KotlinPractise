package com.example.kotlinlib.kotlinbase.operation

import java.util.*

@ExperimentalStdlibApi
fun main() {
    //不可空类型
    var name = "ESun"
    //可空类型
    var name1: String?
    name1 = null
    name1 = "123"

    var str: String? = "eSun"
    //str为空后面不执行 首字母大写
    val cap = str?.capitalize()
    println(cap)

    //为空触发崩溃
    str!!.capitalize()

    val let = str?.let {
        if (it.isBlank()) {
            "default"
        } else {
            it.capitalize()
            "str is $it"
        }
    }
    //空合并操作符
    println(str ?: "your is null")
    println(str?.let { "$it not null" } ?: "your is null")
    try {
        str!!.length
    }catch (e:Exception){

    }

}