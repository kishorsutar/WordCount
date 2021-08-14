package com.motorway.android.wordcount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordCounterViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>()

    val count: LiveData<Int>
        get() = _count

    fun updateCount(char: CharSequence?) {
        _count.value = char?.toString()?.trim()?.split(" ")?.size
    }
}
