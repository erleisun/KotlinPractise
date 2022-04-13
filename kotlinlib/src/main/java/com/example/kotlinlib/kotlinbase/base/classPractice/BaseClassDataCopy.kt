package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * 数据类 copy函数 只会重新copy主构造函数中的数据 不会copy类内部的数据 同理 equals hashcode也只管主构造函数
 */
data class Ball(var name: String, var age: Int) {

    var info: String = ""

    init {
        println("主构造函数被调用")
    }

    constructor(name: String, age: Int, info1: String) : this(name, 100) {
        println("次构造函数被调用")
        info = info1
    }

    override fun toString(): String {
        return "Ball = $name $age $info"
    }
}

fun main() {

    val ball = Ball("jack", 10, "my name is jack")
    //如果Ball类没有重写toString 则不会打印info的信息
    println("ball = $ball")
    val copyBall = ball.copy()
    println(copyBall) //调用info后 copy的info信息会被丢弃

}