package com.motorway.android.wordcount

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider

class WordCounterActivity : AppCompatActivity() {
    private lateinit var viewModel: WordCounterViewModel
    private lateinit var wordCounterEditText: EditText
    private lateinit var loadText: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_counter)
        initViewModel()
        setupUi()
        initDataObservers()
    }

    private fun setupUi() {
        wordCounterEditText = findViewById(R.id.edit_query)
        wordCounterEditText.doOnTextChanged { char, _, _, _ ->
            viewModel.updateCount(char)
        }

        loadText = findViewById(R.id.load_button)
        loadText.setOnClickListener {
            wordCounterEditText.setText(getString(R.string.motorway))
        }
    }

    private fun initDataObservers() {
        val counter = findViewById<TextView>(R.id.counter)
        viewModel.count.observe(
            this, {
                counter.text = "$it"
            }
        )
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(WordCounterViewModel::class.java)
    }
}