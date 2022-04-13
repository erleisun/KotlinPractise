package com.example.kotlinlib.kotlinbase.base.collectionPractice

fun main() {
    //不可变的list集合
    val list = listOf<String>("zero", "one", "two")
    println(list[0])
    println(list[1])
    println(list[2])
//    println(list[3])
    //避免奔溃 KT最好使用如下的函数 防止奔溃 如果为空 给默认值
    println(list.getOrNull(3) ?: "3 out of bounds")
    println(list.getOrElse(4) { "out of bonds" })

    //可以将不可变的集合改成可变集合
    val toMutableList = list.toMutableList()
    toMutableList.add("three")
    toMutableList.remove("zero")
    println(toMutableList)

    //可变的list集合
    val mutableListOf = mutableListOf<String>("zero", "one", "two")
    //将可变集合变为不可变的集合
    val toList = mutableListOf.toList()

    //mutableListOf 的可变属性 mutator
    mutableListOf += "张三"
    mutableListOf -= "zero"
    mutableListOf -= "123"
    println(mutableListOf)

    //removeIf 删除指定条件的元素  lambda表达式为true时 删除当前元素
    //mutableListOf.removeIf { true }
    //删除包含指定字符的元素
    mutableListOf.removeIf { it.contains("one") }
    println(mutableListOf)

    //list循环三种方式 针对一个元素
    for (item in mutableListOf) {
        print(item)
    }
    //forEach 针对一个元素
    mutableListOf.forEach() {
        print(it)
    }
    //针对两个元素 下标和下标对应的元素
    mutableListOf.forEachIndexed { index, item ->
        print("index = $index item = $item")
    }

    //解构语法
    val listInt = listOf<Int>(1, 2, 3, 4)
    val (n1, n2, n3) = listInt
    println("n1 = $n1,n2 = $n2,n3=$n3")

    //如果有不想要的值 可以用 _ 代替
    val (_, n4, n5) = listInt
    println("n4 = $n4,n5=$n5")
    val (_, n6) = listInt
    println("n6=$n6")
}


class ListPractice {
}