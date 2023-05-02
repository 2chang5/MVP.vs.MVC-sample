package com.example.mvp.ui.counteractivity

interface CounterContract {

    interface View {
        var presenter: Presenter
        fun setCounterText(count: Int)
    }

    interface Presenter {
        fun add()
        fun sub()
    }
}
