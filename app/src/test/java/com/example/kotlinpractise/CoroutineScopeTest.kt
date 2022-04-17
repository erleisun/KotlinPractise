package com.example.kotlinpractise

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.whileSelect
import org.junit.Test
import org.junit.Assert.*
import java.lang.Exception
import java.lang.IllegalArgumentException


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CoroutineScopeTest {
    @Test
    fun coroutineScope1() {
        //runBlocking是一个阻塞协程 会阻塞当前线程
        runBlocking {
            println("runBlocking start")
            //内部接受一个CoroutineScope  可以在起一个协程 启动一个新协程
            val asyncJob = async {
                delay(5000)
                println("async end")
                200
            }
            //阻塞当前流程
            println("runBlocking end ${asyncJob.await()}")

            //又启动一个新协程
            val launchJob = launch {
                delay(5000)
                println("launch end")
            }
        }

        println("CoroutineScope1 test end")
    }

    /**
     * 协程的启动模式
     */
    @Test
    fun coroutineScopeStartMode() {
        runBlocking {
            //start是启动模式，默认为default 在调度前如果协程被取消 立即进入取消流程
            val launchDefault = launch(start = CoroutineStart.DEFAULT) {
                println("launchDefault")
                delay(1000)
            }
            launchDefault.cancel()

            //执行到第一个挂起点时不响应取消操作
            val launchAtomic = launch(start = CoroutineStart.ATOMIC) {
                println("ATOMIC")
                delay(1000)
            }
            launchAtomic.cancel()

            //cancel会直接进入异常结束状态，需要调用start join await等才正在开始执行
            val launchLazy = launch(start = CoroutineStart.LAZY) {
                println("LAZY")
                delay(1000)
                30
            }
            launchLazy.start()

            //UNDISPATCHED 表示如果当前在主线调用，在没遇到suspend挂起函数之前都会使用主线程执行
            val launchUnDispatched =
                launch(context = Dispatchers.IO, start = CoroutineStart.UNDISPATCHED) {
                    println("launchUnDispatched startThread = ${Thread.currentThread()}")
                    //遇到挂起函数 切换到其他线程
                    delay(1000)
                    println("launchUnDispatched endThread = ${Thread.currentThread()}")
                }
        }
    }

    @Test
    fun coroutineScopeBuilder() {
        runBlocking {
            //如果一个协程失败了 那么所有协程都会被取消
            //继承父协程runBlocking到作用域
            coroutineScope() {
                async { }
                try {
                    async {
                        throw IllegalArgumentException()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            //其中一个协程失败了 不会影响其他的协程
            supervisorScope {
                async { }
                async { }
            }
        }
    }

    @Test
    fun scopeCancel() = runBlocking<Unit> {
        //构建了以个新的协程作用域，没有继承runBlocking的作用域，所以runBlocking也不会等待期构建到协程执行完成
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
        }
        scope.launch {
        }
        //作用域取消后，所有被创建的协程都会被取消
        scope.cancel()
    }

    @Test
    fun cancelCpuTaskByEnsureActive() = runBlocking<Unit> {
        val job = launch(Dispatchers.Default) {
            val i = 0;
            while (i < 10) {
                ensureActive()
//                yield()
                delay(500)
                println("print ${i.plus(1)}")
            }
        }
        delay(3000)
        //不能取消密集型任务 但是可以改变当前状态 使用ensureActive 判断当前是否被取消 会终止执行
        job.cancel(CancellationException("offer cancel"))


    }

    //超时自动取消协程 withTimeoutOrNull 默认返回Null  withTimeout会抛出一个异常
    @Test
    fun withTimeOut() = runBlocking<Unit> {
//        val withTimeoutOrNull = withTimeoutOrNull(2000) {
        val withTimeoutOrNull = withTimeout(2000) {
            repeat(100) {
                println("repeat ")
                delay(500)
            }
            "done"
        }.runCatching {
            println("runCatching")
        }

//         println("withTimeoutOrNull = ${withTimeoutOrNull ?: "back null turn jack"}")
        println("withTimeoutOrNull = $withTimeoutOrNull")
    }

}