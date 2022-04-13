package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * 数据类 一般用于java 的bean类，会重写 equal hashcode copy get set等方法
 */
//一个普通的类 父类继承成Any
class ResponseResultBean(var message: String, var code: Int, var data: String) {
}

// 有data修饰的类为数据类
data class ResponseResultBean1(var message: String, var code: Int, var data: String) {
}

fun main() {

    val response = ResponseResultBean("message", 200, "this is data")
    val response1 = ResponseResultBean1("message", 200, "this is data")
    //普通类因为继承是Any 没有重写toString方法 会直接调用Any的toString 对象地址
    println(response)//com.example.kotlinlib.kotlinbase.base.classPractice.ResponseResultBean@3b6eb2ec
    //data类 默认实现了toString 所以能够打印出具体的值
    println(response1)//ResponseResultBean1(message=message, code=200, data=this is data)

    //== 相当于java的equal 比较值  === 比较的是引用(地址)
    println(ResponseResultBean("message", 200, "this is data")
    == ResponseResultBean("message", 200, "this is data"))

    println(ResponseResultBean1("message", 200, "this is data")
            == ResponseResultBean1("message", 200, "this is data"))

}