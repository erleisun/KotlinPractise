package com.example.kotlinlib.kotlinbase.funPractice
//function as params in function

fun main() {

    loginApi("ESun1", "123456") { message, errorCode ->
        println("login message = $message,errorCode = $errorCode")
    }

    //函数引用 可以用双冒号替换
    loginApi("ESun","123456",::responseResult)
}

fun responseResult(message:String,errorCode:Int){
    println("login message = $message,errorCode = $errorCode")
}

const val NAME = "ESun"
const val PWD = "123456"

//response作为一个函数参数 带lambda建议增加内联 减少函数定义
inline fun loginApi(name: String, pwd: String, response: (String, Int) -> Unit) {
    if (name.isEmpty() || pwd == null) return

    if (webServerLoginApi(name, pwd)) {
        response("success", 200)
    } else {
        response("faile", -1)
    }
}

fun webServerLoginApi(name: String, pwd: String): Boolean {
    return name == NAME && pwd == PWD
}