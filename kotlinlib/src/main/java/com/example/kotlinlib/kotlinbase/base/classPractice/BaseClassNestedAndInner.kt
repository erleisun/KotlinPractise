package com.example.kotlinlib.kotlinbase.base.classPractice

/**
 * 嵌套类 就是默认的 类中创建类，  不能直接访问外部类的成员
 *
 * 如果要成为内部类 必须要在类的前面加上inner关键字修饰，可以直接访问外部类
 */
class Body() {
    //不会对外暴露 默认是private final  只会对外暴露 getInfo()方法
    public val info = "my body"

    //如果需要访问外部类信息 需要增加inner
    inner class RightHand() {
        val tag = "this is hand"
        fun handInfo() {
            //info 相当于java的 Body.this.info
            println("this is right hand of $info")
//            println("this is right hand of $info")
        }
    }

    //没有inner不叫内部类 叫嵌套类
    class LeftHand() {
        fun showInfo(): String {
            return "leftHand"
        }
    }
}

fun main() {
    println("info $BaseClassCompanionObject.info")
    BaseClassCompanionObject.show()
    //嵌套类的使用
    Body.LeftHand().showInfo()
    //内部类的使用 只有通过外部类才能使用
    Body().RightHand()
}