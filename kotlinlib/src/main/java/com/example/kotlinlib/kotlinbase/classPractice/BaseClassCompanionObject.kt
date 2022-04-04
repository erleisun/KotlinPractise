package com.example.kotlinlib.kotlinbase.classPractice

class BaseClassCompanionObject {
    //kt没有static 关键字 companion相当于java的static变量  伴生对象只会初始化一次
    companion object {
        val info = "info"
        fun show(){
            println("companion show")
        }
    }
}

fun main() {

    println("info $BaseClassCompanionObject.info")
    BaseClassCompanionObject.show()

}