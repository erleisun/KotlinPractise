package com.example.kotlinlib.kotlinbase.base.extend

/**
 * 扩展文件  可以将扩展方法都写在一个文件中 后面哪里使用 就需要导入这个包
 */

//将list的父类 Iterable进行扩展
fun <E> Iterable<E>.random() = this.shuffled().first()
fun <E> Iterable<E>.random1() = this.shuffled().first()
class ExtendFile {
}