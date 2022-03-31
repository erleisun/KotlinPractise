package com.example.kotlinlib.kotlinbase.classPractice

/**
 * KT 类的联系
 */
//主构造函数 临时变量 不带val 和var时 不可以之间使用，需要在内部定义变量接受后在使用
class BaseClass1(_name: String, _age: Int, _Info: String) {
    //对变量重写属性值
    var name = _name
        get() = field
        private set(value) {
            field = value
        }

    val age = _age
    val info = _Info

}


fun main() {
    val baseClass1 = BaseClass1(_name = "tom", _age = 1, _Info = "11")
    println(baseClass1.name)
}