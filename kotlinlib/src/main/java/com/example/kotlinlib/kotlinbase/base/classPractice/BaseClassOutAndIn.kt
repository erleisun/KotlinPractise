package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * out 协变 相当于java 的  <? extends xx>  子类可以直接给父类赋值  父类= 子类 只能获取 不能修改
 * in 逆变  相当于java 的  <? super xx>  父类可以直接给子类赋值    子类= 父类  只能修改 不能获取
 */
class BaseClassOutAndIn() {
}

class Producer<T>(_item: T) {

    var item: T = _item

    fun producer(): T {
        return item
    }

//    fun <T> consume(__item: T) {
//        item = __item
//    }

}

fun main() {

}