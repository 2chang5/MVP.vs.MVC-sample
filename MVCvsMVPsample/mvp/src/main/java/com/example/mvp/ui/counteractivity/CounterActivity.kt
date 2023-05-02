package com.example.mvp.ui.counteractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mvp.R

class CounterActivity : AppCompatActivity(), CounterContract.View {

    override lateinit var presenter: CounterContract.Presenter

    private val tvCount by lazy { findViewById<TextView>(R.id.tv_count) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        initMinusButtonClickListener()
        initPlusButtonClickListener()
    }

    private fun initPlusButtonClickListener() {
        findViewById<Button>(R.id.btn_plus).setOnClickListener {
            presenter.add()
        }
    }

    private fun initMinusButtonClickListener() {
        findViewById<Button>(R.id.btn_minus).setOnClickListener {
            presenter.sub()
        }
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }

    override fun setCounterText(count: Int) {
        tvCount.text = COUNT_PRINT_FORMAT.format(count)
    }

    companion object {
        private const val COUNT_PRINT_FORMAT = "    %d    "
    }
}
