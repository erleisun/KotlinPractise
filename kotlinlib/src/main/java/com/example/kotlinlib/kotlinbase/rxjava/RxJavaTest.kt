package com.example.kotlinlib.kotlinbase.rxjava

/**
 * 练习写一个类似RxJava样式的 create  map observer操作符
 */
class RxJavaTest {

}


fun main() {
    "123".apply {

    }
    "123".let {

    }

//    with(12)

    create {
        "123"
        345
        true
        123.345
    }.map {
        "first xx $it xxx"
    }.map {
        "second xx ${it.item} second"
    }.observer {
        println(it.item)
    } 
}

//create操作符 无参进来 有值 出去
private inline fun <T> create(action: () -> T): T {
    return action()
}

//创建中间类保存
class RxJavaObject<T>(var item: T)

//map转换操作符 进来IP类型 出去OP类型
private inline fun <INP, OUTP> INP.map(actionMap: (INP) -> OUTP): RxJavaObject<OUTP> {
    return RxJavaObject(actionMap(this))
}

private inline fun <T> T.observer(action: (T) -> Unit): Unit {
    return action(this)
}


