package com.example.kotlinlib.kotlinbase.base.collectionPractice

fun main() {
    //两个four 只会有一个保存在set集合中
    val setOf = setOf<String>("one", "two", "three", "four", "four")
    println(setOf.elementAt(0))
    println(setOf.elementAt(1))
    println(setOf.elementAt(2))

    //和list一样 可以和空操作符一起使用
    println(setOf.elementAtOrElse(3) { "crash 4" })
    println(setOf.elementAtOrElse(5) { "crash 5" })
    println(setOf.elementAtOrNull(5) ?: "you out of bounds")


    //可变Set
    val mutableSetOf = mutableSetOf<String>()

    val mutableListOf = mutableListOf<String>("1", "2", "3")
    //去重
    mutableListOf.toSet().toList()
    //或者直接用快捷函数 内部也是先toSet 在toList
    mutableListOf.distinct()
}


class SetPractice {
}