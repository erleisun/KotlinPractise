package com.example.kotlinlib.kotlinbase.base.classPractice

import java.io.File

//持有this参数 T.()
private inline fun <T> T.mApply(block: T.() -> Unit): T {
    block()
    return this
}
//传入it 参数(T)
private inline fun <T> T.mLet(block: (T) -> Unit){
    block(this)
}

fun main() {

    File("a.txt").mApply {
        setReadable(true)
    }

    File("b.txt").mLet {
        it.setExecutable(false)
    }

}