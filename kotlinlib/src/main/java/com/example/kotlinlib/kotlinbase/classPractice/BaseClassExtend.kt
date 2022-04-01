package com.example.kotlinlib.kotlinbase.classPractice

import java.io.File
import java.lang.reflect.Field

class BaseClassExtend {
}

//没有open关键字修饰的类 默认都是final的 不能被继承 加上open关键字 会去除final修饰
open class Person(var name: String) {
    //如果需要被子类重写 需要加上open关键字
    open fun showName() {
        println("name is $name")
    }
}

class Student(var subName: String) : Person(subName) {
    //子类重写
    override fun showName() {
        println("name is $subName")
    }

    fun myName() {
        println("my name is subName")
    }
}

/**
 * Any是默认实现的 是全类的超类
 */
class Obj1 : Any() {

}

fun main() {

    val per: Person = Student("hello")
    per.showName()
    println(per is Student)
    println(per is Person)
    println(per is File)

    //子类父类转换
    if (per is Student) {
        (per as Student).myName()
    }

}