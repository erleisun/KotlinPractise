package com.example.kotlinlib.kotlinbase.classPractice

/**
 * 重写接口时 除了要重写函数  还需要重写变量
 */
interface IUSB {
    var deviceType: String
    var deviceInsertType: String

    fun showDeviceInfo(): String
}

class Mouse(
    override var deviceType: String = "USB3.0",
    override var deviceInsertType: String = "mouseType"
) : IUSB {
    override fun showDeviceInfo(): String {
        return "Mouse deviceType $deviceType, deviceInsertType $deviceInsertType"
    }

}

class Keyboard : IUSB {

    override var deviceType: String = "USB3.0"
        get() = field
        set(value) {
            field = value
        }

    override var deviceInsertType: String = "this is KeyBoard"
        get() = field
        set(value) {
            field = value
        }

    override fun showDeviceInfo(): String {
        return "Mouse deviceType $deviceType, deviceInsertType $deviceInsertType"
    }
}

fun main() {

    val iUsb: IUSB = Mouse(
        "out deviceType",
        "out InsertType"
    )
    println(iUsb.showDeviceInfo())

    val iUsb1: IUSB = Keyboard()
    println(iUsb1.showDeviceInfo())

}