package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * KT 类的联系
 */
//主构造函数 带val 或者 var时 可以直接使用，不需要在内部定义变量接受后在使用  还可以给参数添加默认值
class BaseClass3(_name: String, _age: Int = 33) {
    var mAge = _age
    var mName = _name

    //次构造函数一定要继承主构造函数
    constructor(name: String, age: Int, info: String = "hello info") : this(name, age) {
        mName = name
    }

    fun show() {
        println("name = $mName")
        println("age = $mAge")
    }

}

fun main() {
    //
    val baseClass3 = BaseClass3(name = "tom", age = 1, info = "11")
    baseClass3.show()
}