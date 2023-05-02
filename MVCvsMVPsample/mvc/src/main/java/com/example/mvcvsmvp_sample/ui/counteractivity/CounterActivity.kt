package com.example.mvcvsmvp_sample.ui.counteractivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvcvsmvp_sample.R
import com.example.mvcvsmvp_sample.domain.Counter

class CounterActivity : AppCompatActivity() {

    private val counter by lazy { Counter() }
    private val tvCount by lazy { findViewById<TextView>(R.id.tv_count) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMinusButtonClickListener()
        initPlusButtonClickListener()
    }

    private fun initPlusButtonClickListener() {
        val btnPlus = findViewById<Button>(R.id.btn_plus)
        btnPlus.setOnClickListener {
            tvCount.text = COUNT_PRINT_FORMAT.format(counter.add())
        }
    }

    private fun initMinusButtonClickListener() {
        val btnMinus = findViewById<Button>(R.id.btn_minus)
        btnMinus.setOnClickListener {
            tvCount.text = COUNT_PRINT_FORMAT.format(counter.sub())
        }
    }

    companion object {
        private const val COUNT_PRINT_FORMAT = "    %d    "
    }
}
