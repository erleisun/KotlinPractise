package com.example.kotlinlib.kotlinbase.base.classPractice

class BaseClassSealed {
}

/**
 * 密封类的成员都继承于主类
 */
sealed class Exam() {
    object Fraction : Exam()
    object Fraction1 : Exam()
    class Fraction2(var name: String) : Exam()
}

class Teacher(var exam: Exam) {

    fun show(): String {
        return when (exam) {
            is Exam.Fraction -> "this is fraction"
            is Exam.Fraction1 -> "this is fraction"
            is Exam.Fraction2 -> "this is fraction4 ${(exam as Exam.Fraction2).name}"
        }
    }
}

fun main() {
    println(Teacher(Exam.Fraction2("jack")).show())
    println(Teacher(Exam.Fraction).show())
}