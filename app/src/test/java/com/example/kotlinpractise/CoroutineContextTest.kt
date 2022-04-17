package com.example.kotlinpractise

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.IllegalArgumentException

/**
 * 协程的上下文  由几部分组成  job + CoroutineDispatcher + CoroutineName + CoroutineExceptionHandler组成
 */
class CoroutineContextTest {
    /**
     * 协程上下文
     */
    @Test
    fun coroutineContext() = runBlocking<Unit> {
        //协程可以增加名称 得到是一个CoroutineContext 协程上下文 当前线程时 会打印出协程名称
        launch(Dispatchers.Default + CoroutineName("coroutineTest")) {
            println("currentThreadName = ${Thread.currentThread()}")
        }
    }

    /**
     * 协程上下文继承
     */
    @Test
    fun coroutineExtend() = runBlocking<Unit> {
        //构建一个协程到作用域
        val scope = CoroutineScope(Job() + Dispatchers.IO + CoroutineName("extend"))
        //使用协程作用域 启动一个协程
        val launch = scope.launch {
            println("launch ${coroutineContext[Job]}  threadName = ${Thread.currentThread()}")
            //在启动一个协程
//            val result = withContext(Dispatchers.Default) {
//                println("async ${coroutineContext[Job]}  threadName = ${Thread.currentThread()}")
//                200
//            }
            //创建到新协程 会将当前协程作为父协程
            val result = async {
                println("async ${coroutineContext[Job]}  threadName = ${Thread.currentThread()}")
                200
            }.await()
        }
        //等待协程执行完成
        launch.join()
    }

    @Test
    fun coroutineExtend2() = runBlocking<Unit> {
        //协程异常处理 _ 表示解构 不需要当前参数 使用 _ 代替，可以节省内存
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler = ${exception.message}")
        }
        //构建协程默认作用域
        val scope = CoroutineScope(
            Dispatchers.Main
                    + CoroutineName("extend-2")
                    + coroutineExceptionHandler
        )
        //可以使用新到默认分发器覆盖作用域中到分发器
        val launch = scope.launch(Dispatchers.IO) {
            println("xxx")
            throw IllegalArgumentException("eeeeeeeeeeeeeeeeeeeee")
        }
        launch.join()
    }

    /**
     * 普通到JOb协程 如果有一个协程发生异常 会导致其他协程也中断执行  需要使用SuperVisorJob 互不影响
     */
    @Test
    fun superVisorJobTest() = runBlocking<Unit> {
        //一个协程异常 不影响其他协程
        val scope = CoroutineScope(SupervisorJob())
        //一个协程异常 所有作用域协程都异常
//        val scope = CoroutineScope(Job())
        val launch = scope.launch {
            delay(1000)
            println("scope launch")
            throw IllegalArgumentException("launch illegal")
        }

        val async = scope.async {
            try {
                delay(10000)
            } finally {
                println("scope async process finish")
            }
        }

        //可以将所有协程都移除
//        scope.cancel()

        joinAll(launch, async)
    }

    /**
     * 捕获异常 需要在跟协程捕获 不然会捕获失败
     */
    @Test
    fun coroutineException() = runBlocking<Unit> {
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler = ${exception.message}")
        }

//        val scope = CoroutineScope(this.coroutineContext)
        val scope = CoroutineScope(Job())
        //必须在跟协程处理exception
        scope.launch(exceptionHandler) {
            println("root launch ")
            launch{
                println("second launch")
                throw IllegalArgumentException("xxxxx")
            }
        }

        //如果在子协程处理错误 不能捕获
//        launch {
//            println("root launch ")
//            launch(exceptionHandler) {
//                println("second launch")
//                throw IllegalArgumentException("xxxxx")
//            }
//        }
        delay(10000)

    }
}