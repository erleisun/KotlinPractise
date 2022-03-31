package com.example.kotlinlib.kotlinbase.classPractice

/**
 * KT 类的联系
 */
//主构造函数 带val 或者 var时 可以直接使用，不需要在内部定义变量接受后在使用  还可以给参数添加默认值
class BaseClassInit4(_name: String, var _age: Int = 33) {

    //和init{}块是平级的，谁在前就先执行谁   主构造函数执行完 之后才执行次构造函数
    var mAge = _age
    var mName = _name
    //不是java的static模块，只有柱构造被调用的时候才会调用init{}代码块
    //可以用来校验参数是否满足要求 不满足要求 抛出异常
    init {
        println("主构造函数的init 函数被调用")
    }

    //次构造函数一定要继承主构造函数
    constructor(name: String, age: Int, info: String = "hello info") : this(name, age) {
        mName = name
        println("次构造函数被调用")
    }

    fun show() {
        println("name = $mName")
        println("age = $mAge")
    }

}

fun main() {
    //
    val baseClass4 = BaseClassInit4(name = "tom", age = 1, info = "11")
    baseClass4.show()
}