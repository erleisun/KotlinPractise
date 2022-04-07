package com.example.kotlinlib.kotlinbase.classPractice

/**
 *自定义一个泛型扩展函数
 */
//输入类型是I,输出类型是O
//返回的类型 随着lambda中返回的类型决定 不上固定的
//有lambda函数 增加inline 提高性能
//private 自定义给自己使用
//对I 扩展  this就等于I 对I进行重新操作
private inline fun <I, O> I.mLet(block: (I) -> O): O {
    return block(this)
}

fun main() {

    val mLet = "abc".mLet {
        456
        true
    }

    "abc".apply {
    }

    "abc".let {

    }

    "abc".also {
        it.length
    }

    "abc".run {
        length
    }

    with("abc"){
      1
    }

}