package com.example.kotlinpractise

import android.renderscript.Sampler
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.junit.Test


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CoroutineFlowTest {
    @Test
    fun coroutineScope1() {

    }

    @Test
    fun getFlow() = runBlocking {
        //withContext阻塞 需要等返回结果
        val withContext = withContext(Dispatchers.IO) {
            for (k in 1..3) {
                delay(1000)
                println("withContext = $k")
            }
            123
        }

        println("withContext end is $withContext")

        //不阻塞当前线程
        launch  {
            for (k in 1..3) {
                delay(1000)
                println("launch = $k")
            }
        }

        sampleFlow().collect { value ->
            println("collect = $value")
        }
        println("getFlow end")


    }

    /**
     * 调用flow需要在协程中调用
     */
    private fun sampleFlow() = flow<Int> {
        //flow不是阻塞的操作
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }

}