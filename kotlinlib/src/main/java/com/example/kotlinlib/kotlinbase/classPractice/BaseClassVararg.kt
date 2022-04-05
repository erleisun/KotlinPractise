package com.example.kotlinlib.kotlinbase.classPractice

class BaseClassVararg<T>(var b: Boolean, vararg objects: T) {
    //开启泛型T的只读模式
    private val objectArray: Array<out T> = objects

    fun getR1(): Array<out T>? = objectArray.takeIf { b }
}

fun main() {

}