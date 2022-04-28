package com.example.kotlinpractise.util

import com.example.kotlinpractise.bean.Car

class TrafficSystem(c1: Car, c2: Car, c3: Car) {
     var car1: Car = c1

     var car2: Car = c2

     var car3: Car = c3

    fun calculate() = car1.hashCode()

}