package com.example.kotlinlib.kotlinbase.base.funPractice
//function as params in function

fun main() {
    //返回值是一个匿名函数
    val showMethod = showMethod("ESun")
    println(showMethod("hello",123))
}

fun showMethod(name: String): (String, Int) -> String {
    return { v1, v2 ->
        "name is $name,v1 = $v1, v2 = $v2"
    }
}