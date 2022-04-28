package com.example.kotlinpractise.mockk

import com.example.kotlinpractise.bean.Car
import com.example.kotlinpractise.util.TrafficSystem
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TrafficCarTest {

//    lateinit var car1: Car
//
//    lateinit var car2: Car
//
//    lateinit var car3: Car
//
//    var trafficSystem = TrafficSystem()

    @Before
    fun setUp() {
        println("setUp")
    }

    @Test
    fun first() {
        val c1 = mockk<Car>()
        val c2 = mockk<Car>()

        every { c1.toString() } returns "c1"
        every { c2.toString() } returns "c2"

        val trafficSystem = TrafficSystem(c1,c2,c1)
        assertEquals("c1+c2",trafficSystem.calculate())

        //验证两个字段是否被调用过
        verify {
            c1.hashCode()
            c2.hashCode()
        }
    }

}