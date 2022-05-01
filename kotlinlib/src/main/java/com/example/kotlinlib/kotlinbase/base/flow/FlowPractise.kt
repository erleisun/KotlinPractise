package com.example.kotlinlib.kotlinbase.base.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

fun main() {

    runBlocking(Dispatchers.Default) {
        println("begin thread = ${Thread.currentThread().name}")
//        flow1()
//        flowAsFlow()
//        flowFlowOf()
//        flowOn()
//        launchIn()
//        launchIn1()
//        flowCancel(this)
        flowBackPressure()
    }
}

/**
 * 背压 一般对生产则 消费者模式  生产的快 或者 消费的快 如果处理 1是增大缓存 2是切换线程异步执行
 */
private suspend fun flowBackPressure() {
    //flow 生产数据
    val flow = flow<Int> {
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    }

    val time = measureTimeMillis {
        flow

//            .conflate()
//            .flowOn(Dispatchers.IO) //切换线程
//            .buffer(10)//增加缓存
            .collectLatest { value -> //只取最后一个值
//            .collect { value ->
                delay(300)
                println("value = $value")
            }
    }
    println("time = $time")
}

/**
 * cancellable每次检查  取消flow即取消协程即可
 */
private suspend fun flowCancel(scope: CoroutineScope) {

    (1..5).asFlow().cancellable().collect { value ->
        println("value = $value")
        if (value == 3) {
            scope.cancel()
        }
    }
}

/**
 * flow源事件
 */
private fun events(): Flow<Int> {
    return (1..3).asFlow()
        .onEach { delay(1000) }
        .flowOn(Dispatchers.IO)
}

/**
 * 使用launchIn 指定collect在哪个协程执行
 */
private suspend fun launchIn1() {
    events()
        .onEach {
            println("launchIn1 each threadName = ${Thread.currentThread().name}")
        }.launchIn(CoroutineScope(Dispatchers.Default))//使用launchIn指定线程 返回是一个Job 可以执行取消等操作
        .join()//等待子协程执行完
}


/**
 * launchIn代替collect指定线程收集元素
 */
private suspend fun launchIn() {

    val flow = (1..3).asFlow().onEach {
        delay(1000)
    }.flowOn(Dispatchers.IO)

    flow.onEach {
        println("onEach = $it")
    }.collect {
        println("collect = $it")
    }
    //.launchIn(CoroutineScope(Dispatchers.Main))
}

/**
 * flow默认发射和收集在同一个线程 继承上下文  如果要发射在子线程 接收在其他线程可以使用flowOn切换
 */
private suspend fun flowOn() {
    flow {
        println("flowOn thread = ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.Default)
        .collect { value ->
            println("value = $value collect thread = ${Thread.currentThread()}")
        }
}

/**
 * flowOf创建流
 */
private suspend fun flowFlowOf() {
    flowOf("one", "two", "three").onEach {
        delay(1000)
    }.collect { value ->
        println("value = $value")
    }
}

/**
 * asFlow创建流
 */
private suspend fun flowAsFlow() {

    (1..7).asFlow().filter {
        it % 2 == 0//过滤取偶数
    }.map {
        "$it is even number" //对每个元素转换
    }.collect { value ->
        println("value is $value")
    }

}

private suspend fun flow1() {
    val flow = flow()
    flow.collect { value ->
        println("value first = $value")
    }
    println("first collect end")
    flow.collect { value ->
        println("value second = $value")
    }
}

/**
 * 冷流 调用flow的时候不会执行 函数体， 只有当调用flow的collect的时候才执行
 */
private fun flow() = kotlinx.coroutines.flow.flow {
    println("flow start")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}
