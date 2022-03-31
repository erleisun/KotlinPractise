package com.example.kotlinlib.kotlinbase.classPractice

/**
 * KT 类的联系
 */
class BaseClassLateInit4(_name: String) {

    //稍后初始化，一定是var修饰 如果没有被初始化 直接使用 会直接奔溃
    lateinit var response: String

    fun getResponse() {

        response = "you are login success"
    }

    fun show() {
        if (!::response.isInitialized) {
            println("response isInitialized false")
        }else{
            println("response = $response")
        }
    }

}

fun main() {
    val baseClassLateInit4 = BaseClassLateInit4(_name = "tom")
    baseClassLateInit4.getResponse()
    baseClassLateInit4.show()
}