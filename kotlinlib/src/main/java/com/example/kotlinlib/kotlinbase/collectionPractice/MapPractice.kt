package com.example.kotlinlib.kotlinbase.collectionPractice

fun main() {
    //map创建
    val mapOf = mapOf<Double, String>(11.1 to "one", 11.2 to "two")
    val mapOf1 = mapOf(Pair(11.1, "one"), Pair(11.2, "two"))

    //读取map 值
    println(mapOf[11.1])
    println(mapOf.get(11.1))
    //读取不到时给到默认值 getOrDefault 或者 getOrElse
    println(mapOf.getOrDefault(11.1, "-1"))
    println(mapOf.getOrElse(11.1) { -1 })

    //map的遍历
    mapOf.forEach { it: Map.Entry<Double, String> ->
        println("map forEach ${it.key} value ${it.value}")
    }
    //第二种方式
    mapOf.forEach { key, value ->
        println("map forEach $key value $value")
    }

    //第三种
    mapOf.forEach { (key: Double, value: String) ->
        println("map forEach $key value $value")
    }

    //第四种 for循环
    for (item: Map.Entry<Double, String> in mapOf) {
        println("map forEach ${item.key} value ${item.value}")
    }

    //可变map集合操作
    val mutableMapOf = mutableMapOf<Double, String>(11.2 to "jack", Pair(11.3, "tom"))
    mutableMapOf+=12.3 to "mary"

    //先获取key 为111.1的数据，如果没有就将apple加入,在获取，如果已经有当前key apple就会忽略
    val orPut = mutableMapOf.getOrPut(111.1) { "apple" }
    println("orPut = $orPut")
}

class MapPractice {
}