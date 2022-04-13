package com.example.kotlinlib.kotlinbase.base

fun main() {
    val base = Base()
    base.fun1()
    base.fun2()
    base.fun3()
    base.fun4()
    base.fun5()


}

class Base {
    //匿名函数
    fun fun1() {
        //函数声明
        val methodAction: () -> String
        //函数返回 匿名函数不需要return 最后一行就是返回
        methodAction = {
            "ESun" //return ESun
        }
        //调用
        println("method = ${methodAction()}")
    }

    //函数参数
    fun fun2() {
        //定义和实现合并 相当于fun methodAction(num1:Int,num2:Int,num3:Int){return xxx}
        val methodAction: (Int, Int, Int) -> String = { num1, num2, num3 ->
            "methodAction is $num1 $num2 $num3"
        }
        //methodAction.invoke(1,2,3) 等价于下面这种写法
        println(methodAction(1, 2, 3))
    }

    //如果函数只有一个参数的时候 会使用it关键字代替
    fun fun3() {
        val methodAction: (String) -> String = {
            "this is $it"
        }
        println(methodAction("ESun"))
    }

    //自动推断函数的返回值类型
    fun fun4() {
        val method1 = { v1: Double, v2: Int, v3: Float ->
            "$v1 and $v2 $v3"
        }
        println(method1(12.1, 1, 15.5f))

        //无参函数
        val method2 = {
            123
        }
        println(method2())
    }

    //匿名函数等价于 lambda 表达式
    fun fun5() {
        //相当于 weekResultMethod :(Int) -> Any = {num:Int -> xxx}
        val weekResultMethod = { num: Int ->
            //返回值又返回String 又返回int 最后会推断为返回any
            when (num) {
                1 -> "MON"
                2 -> "Thu"
                3 -> "Wed"
                else -> -1
            }
        }
        println(weekResultMethod(4))
    }

}