package com.example.kotlinlib.kotlinbase.base.funPractice

/**
 * anonymous practice
 */
fun main() {

    val len = "ESun".count()
    val len1 = "ESun".length
    //anonymous fun ,count given String have s char numbers
    val len2 = "ESun".count{
        it == 'S'
    }
}


class AnonymousFun {
}