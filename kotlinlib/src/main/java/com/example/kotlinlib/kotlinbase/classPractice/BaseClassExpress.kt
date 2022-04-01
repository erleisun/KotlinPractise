package com.example.kotlinlib.kotlinbase.classPractice

open class BaseClassExpress {
    open fun getOne() {
        println("getOne")
    }

    open fun getTwo() {
        println("get two")
    }
}

//匿名类可以直接使用object:  如果是具名类相当于继承父类

class Express() : BaseClassExpress() {
    //可以重写子函数
}

interface Callback {
    fun run()
}

fun main() {
    //不是一个单例 是匿名对象的表达式 可以重写父类的函数
    val value = object : BaseClassExpress() {
        override fun getOne() {
            super.getOne()
        }

        override fun getTwo() {
            super.getTwo()
        }
    }

    println(value.getOne())

    //是一个lambda的表达式
    Runnable {

    }

    object : Runnable {
        override fun run() {
            TODO("Not yet implemented")
        }
    }

    //KT接口
    val callback = object : Callback {
        override fun run() {
            TODO("Not yet implemented")
        }
    }
    callback.run()
    //kotlin接口不可以直接使用lambda的表达式
//    Callback{
//    }
    //JAVA对象在kotlin中 可以直接使用lambda的表达式
    Runnable {

    }

}