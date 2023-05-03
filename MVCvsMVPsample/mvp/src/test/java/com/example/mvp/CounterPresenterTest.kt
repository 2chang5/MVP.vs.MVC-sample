package com.example.mvp

import com.example.mvp.ui.counteractivity.CounterContract
import com.example.mvp.ui.counteractivity.CounterPresenter
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CounterPresenterTest {
    private lateinit var presenter: CounterPresenter
    private lateinit var view: CounterContract.View

    @Before
    fun setUp() {
        view = mockk()
        presenter = CounterPresenter(view)
    }

    // 이렇게하면 안드로이드 의존성 없이 view까지 테스트가 가능함  -> 테스트가 용이해짐
    // 목객체를 동작을 재정의 하는것은 그냥 인터페이스를 상속받는 새로운것을 만들면 된다.
    @Test
    fun `더하기 함수를 호출하면 counter의 숫자가 올라간다`() {
        // given : 뭐지??
        // mockk 공식문서 가면 slot라는게 있다 -> 들어오는 인자 훔쳐오는것임
        val slot = slot<Int>()
        every { view.setCounterText(capture(slot)) } answers { print("slot = ${slot.captured}") }

        // when: 더해지는 메서드 호출 (버튼을 누른다고 헷갈릴수 있는데 목적이 그게 아님)
        presenter.add()

        // then: 카운트 숫자가 올라간다
        val actual = slot.captured
        Assert.assertEquals(1, actual)
        verify { view.setCounterText(actual) }
    }

    @Test
    fun `빼기 함수를 호출하면 counter의 숫자가 올라간다`() {
        // given : 뭐지??
        // mockk 공식문서 가면 slot라는게 있다 -> 들어오는 인자 훔쳐오는것임
        val slot = slot<Int>()
        every { view.setCounterText(capture(slot)) } answers { print("slot = ${slot.captured}") }

        // when: 더해지는 메서드 호출 (버튼을 누른다고 헷갈릴수 있는데 목적이 그게 아님)
        presenter.sub()

        // then: 카운트 숫자가 올라간다
        val actual = slot.captured
        Assert.assertEquals(-1, actual)
        verify { view.setCounterText(actual) }
    }
}
