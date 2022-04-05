package com.example.kotlinlib.kotlinbase.classPractice

/**
 * 实现一个功能
 */
data class ClassObject1(var name: String, var age: Int)
data class ClassObject2(var name: String, var age: Int)
data class ClassObject3(var name: String, var age: Int)

class BaseClassReified {
    inline fun <reified T> randomOrDefault(defaultActon: () -> T): T? {
        val objectList: List<Any> = listOf(
            ClassObject1("obj1", 10),
            ClassObject2("obj2", 20),
            ClassObject3("obj3", 30)
        )
        val random = objectList.shuffled().first()
        println("random = $random")
        return random.takeIf { random is ClassObject1 } as T? ?: defaultActon()
    }

}

fun main() {
    val base = BaseClassReified()
    base.randomOrDefault {
        println("use default objClass")
        ClassObject1("default", 100)
    }

}