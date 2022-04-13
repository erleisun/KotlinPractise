package com.example.kotlinlib.kotlinbase.base.classPractice

//KT 枚举也是一个class
enum class Week {
    Monday,
    Tuesday,
    Wednesday,
    Thursday
}


/**
 * 枚举类定义函数
 */
data class LimbsInfo(var info: String, var length: Int) {
}

/**
 * 四肢枚举类
 */
enum class Limbs(private var limbsInfo: LimbsInfo) {
    HAND_RIGHT(LimbsInfo("right_Hand", 100)),
    HAND_LEFT(LimbsInfo("left_hand", 200));

    fun show() {
        println("limbsInfo = $limbsInfo")
    }

    fun update(limbs: LimbsInfo){
        limbsInfo.info = limbs.info
        limbsInfo.length = limbs.length
    }
}

fun main() {

    Limbs.HAND_LEFT.show()
    Limbs.HAND_RIGHT.show()
    Limbs.HAND_RIGHT.update(LimbsInfo("hand_right2",300))
    Limbs.HAND_RIGHT.show()



//    println(Week.Thursday)
//    println(Week.Tuesday is Week)
}