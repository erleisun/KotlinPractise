package com.example.kotlinlib.kotlinbase.extend

/**
 * 集合map 转换 it == 每一个元素  最后返回一个新集合
 * 集合flatMap转换 it 每个元素T 集合1 集合2  最后返回 相当于 List<List<String>> 将每一个元素(集合)加入新集合
 *
 */
class ListMapFunction {
}

fun main() {
    val listOf = listOf("11", "22", "33")
    val map = listOf.map {
        11
    }

    val map1 = listOf.map {
        "[$it]"
    }

    println("map = $map map1 = $map1")

    //需要返回一个list 每次都返回一个集合
    val map2 = listOf.flatMap {
        val listOf1 = listOf("today $it")
        println("listOf1 = $listOf1")
        listOf1
    }
    println(map2)

    val flatMap = listOf.map {
        "你好 $it"
    }.flatMap {
        listOf("listof = $it", "list1= $it")
    }

    println("flatmap = $flatMap")

    val listOfs = listOf(listOf("11", "22"), listOf("aa", "bb"))
    //为true  加入新集合
    listOfs.filter {
        it.contains("11")
    }.map {
        println("result = $it")
    }

    //zip 合并两个集合 返回键值对 map形式
    val listNames = listOf("jack", "jack1")
    val listAge = listOf(1, 2)
    val zip: List<Pair<String, Int>> = listNames.zip(listAge)
    println("zip = $zip")
    println("zip.map = ${zip.toMap()}")
    println("zip.set = ${zip.toMutableSet()}")
    zip.forEach {
        println("key = ${it.first} ,second = ${it.second}")
    }

    zip.toMap().forEach{ k,v->
        println("key = $k  v=$v")
    }
    //可以优化为解构的方式
    zip.toMap().forEach{ (k, v) ->
        println("key = $k  v=$v")
    }

}