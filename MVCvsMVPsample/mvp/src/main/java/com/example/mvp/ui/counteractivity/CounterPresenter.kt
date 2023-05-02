package com.example.mvp.ui.counteractivity

import com.example.mvp.domain.Counter

// 뷰에 접근하기위해 생성자에 뷰를 받음 wjddmlgks Contract를 통해 받음
class CounterPresenter(val view: CounterContract.View) : CounterContract.Presenter {

    // 모델에 의존성이 생긴것임
    val counter = Counter()

    override fun add() {
        view.setCounterText(counter.add())
    }

    override fun sub() {
        view.setCounterText(counter.sub())
    }
}
