package com.example.kotlinlib.kotlinbase.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

class CoroutinesPractice {
}

fun main() {
    //全局的协程
    GlobalScope.launch() {
        //挂起函数需要在协程中运行
        withContext(Dispatchers.IO) {
            delay(1000)

            println("delay end= ${Thread.currentThread()}")
        }

        println("end  ${Thread.currentThread()}")
    }
    Thread.sleep(10000)

//    val mainScope = MainScope()
//    mainScope.launch {
//        delay(3000)
//        println("delay end111=   ${Thread.currentThread()}" )
//    }
}