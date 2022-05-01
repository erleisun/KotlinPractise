import kotlinx.coroutines.flow.transform

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * flow 操作符练习
 */
fun main() {

    runBlocking(Dispatchers.Default) {

        flowTransform()

    }
}

/**
 * 执行请求
 */
private suspend fun performRequest(request: Int): String {
    delay(1000)
    return "perform request $request"
}

private suspend fun flowTransform() {

    (1..5).asFlow()
//        .map { request -> performRequest(request)} //map 可以执行一次转换
        .transform<Int, String> { request ->  //transfrom 可以进行多次转换
            emit("this is transform $request")
            emit(performRequest(request))
        }
        .collect { value ->
            println("value = $value")
        }

}

