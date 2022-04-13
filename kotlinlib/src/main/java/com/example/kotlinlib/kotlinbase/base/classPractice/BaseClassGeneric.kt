package com.example.kotlinlib.kotlinbase.base.classPractice

class Generic<T>(var obj: T) {
    fun show() {
        println("obj is $obj")
    }
}

data class Student1(var name: String) {
}

fun main() {

    val stu: Student1 = Student1("jack")
    Generic(stu).show()

}