package com.example.kotlinlib.kotlinbase.classPractice

/**
 * 对象(object)声明学习
 */

//object相当于java中的一个静态内部类
//public static final BaseClassObject INSTANCE;
object BaseClassObject {
    //java 会放到静态代码块中
    init {
        println("today is sunday")
    }

    fun show() = ("this is show BaseClass")
}

fun main() {
    //object xx即使单例的实例 也是类名
    println(BaseClassObject)
    println(BaseClassObject.show())

}