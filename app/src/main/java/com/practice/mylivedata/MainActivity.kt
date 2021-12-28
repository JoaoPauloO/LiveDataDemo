package com.practice.mylivedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.practice.mylivedata.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private val numberText: TextView by lazy {
        findViewById(R.id.number_text)
    }

    private val startBtn: Button by lazy {
        findViewById(R.id.start_btn)
    }

    private val pauseBtn: Button by lazy {
        findViewById(R.id.pause_btn)
    }

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            viewModel.startTime()
        }

        pauseBtn.setOnClickListener {
            viewModel.pauseTime()
        }

        viewModel.seconds.observe(this) {
            numberText.text = it.toString()
        }

        viewModel.finished.observe(this) {
            if (it) {
                Toast.makeText(this, "Contagem iniciada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Contagem finalizada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}