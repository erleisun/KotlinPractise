package com.example.kotlinlib.kotlinbase.classPractice

/**
 * KT 类的联系
 */
class ClassPractice {

}

class BaseKt {

    //val 属性只重写了get() 没有重写set属性 所以在赋值的时候 不能成功，不能修改
    val age = "1123"

    val number: Int
        get() = (1..1000).shuffled().first()//1道1000取出随机值

    //等价于
    val number1: () -> Int = { (1..100).shuffled().first() }


    var name = "ESun"
    //隐式的java函数
//    @NotNull
//    private void setName(@NotNull String name){
//        this.name = name
//    }

    var value = "ABC"
    //隐式函数 默认带代码
    //get() = field
    //set(value){field = value}

    var info = "this is success"
        //重写了get方法，将首字母变为大写
        get() = field.capitalize()

    var key: String? =""

    //与空操作 符结合使用
    fun getMyKey(): String {
        return key?.let {
            println("length = ${it.length}  ${it.isBlank()}")
            if (it.isBlank()) {
                "value is blank"
            } else {
                "key = $key"
            }
//            "hahah"
        } ?: "key si null"
    }
}


fun main() {
    var baseKT = BaseKt()
    //反编译为java字节码时 都会 getxxx setxxx
    println("info = ${baseKT.info}")

    println("number1 = ${baseKT.number}")
    println("number1 = ${baseKT.number1()}")
    println("number1 = ${baseKT.number1()}")
    println("getMyKey = ${baseKT.getMyKey()}")

}