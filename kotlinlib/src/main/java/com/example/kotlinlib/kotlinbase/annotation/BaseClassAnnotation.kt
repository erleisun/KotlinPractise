@file:JvmName("Stu")//编译时将当前文件修改为 class Stu{}

package com.example.kotlinlib.kotlinbase.annotation

fun doSomething() {
}

private class BaseClassAnnotation {
    @JvmField //方便java方法调用属性直接使用 而不用必须调用getNamesxxx
    var name: String = "nihao"


    @JvmOverloads //可以重载多个参数的函数  方便JAVA调用
    fun doSomething(name: String, age: Int, sex: Char) {
    }

    companion object {
        @JvmStatic//java 可以直接调用
        var age: Int = 1
    }
}