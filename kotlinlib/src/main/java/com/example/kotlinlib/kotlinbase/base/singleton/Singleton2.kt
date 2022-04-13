package com.example.kotlinlib.kotlinbase.base.singleton

/**
 * 饿汉式  相当于Java static{instance = xxxx()} 直接初始化
 */
class Singleton2 private constructor() {

//    相当于java
//    getInstance(){
//        if (instance == null){
//            instance = new Instance()
//        }
//        return mInstance
//    }

    companion object {
        var mInstance: Singleton2? = null
            get() {
                if (field == null) {
                    field = Singleton2()
                }
                return field
            }

        //增加同步 相当于 static synchronized getInstance(){if(== null new Instance())}
        @Synchronized
        fun getInstance(): Singleton2 = mInstance!!
    }

    fun doSomething(): String {
        return "Singleton1 doSomething"
    }
}

fun main() {
    Singleton2.getInstance().doSomething()
}