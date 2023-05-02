package com.example.mvcvsmvp_sample.domain

class Counter {
    private var count = 0

    fun add(): Int {
        return ++count
    }

    fun sub(): Int {
        return --count
    }
}
