package com.example.kotlinlib.kotlinbase.classPractice

/**
 * 实现将输入的类型转换为String获取其他类型输出
 */
class BaseGeneric<T>(var b: Boolean, var inputType: T) {
    //定义map函数实现转换 map是一个lambda表达式 takeIf 如果为true 返回前面  false 返回null
    inline fun <R> map(mapAction: (T) -> R): R? {
        return mapAction(inputType).takeIf { b }
    }
}


//不使用map 直接定义一个map操作转换函数 输入R类型 返回O类型
fun <I, O> myMap(inputType: I, isMap: Boolean = true, mapAction: (I) -> O): O? {
    return if (isMap) mapAction(inputType) else null
}

data class Stud(var name: String, var age: Int)

fun main() {
    val p = BaseGeneric(true, 123)
    val map = p.map {
        "it is $it"
    }
    println("map: $map")

    val p2 = BaseGeneric(false, 123)
    val map2 = p2.map {
        "it is $it"
    }
    println("map2: $map2")

    //Stud转换成String输出
    val myMap = myMap(Stud("jack", 15), false) {
        it.toString()
    }
    println(myMap?.length)
}
