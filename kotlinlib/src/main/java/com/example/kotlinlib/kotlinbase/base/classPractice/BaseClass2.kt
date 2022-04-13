package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * KT 类的联系
 */
//主构造函数 带val 或者 var时 可以直接使用，不需要在内部定义变量接受后在使用
class BaseClass2(var name: String, val age: Int, var info: String) {

    //直接使用name
    fun show() {
        println("name = $name")
    }

}

fun main() {
    val baseClass2 = BaseClass2(name = "tom", age = 1, info = "11")
    baseClass2.show()
}