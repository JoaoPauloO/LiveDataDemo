package com.practice.mylivedata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {

    private var stateOfChronometer: Boolean = false

    private val _finished = MutableLiveData<Boolean>()
    val finished get() = _finished

    private val _seconds = MutableLiveData<Int>()
    val seconds get() = _seconds

    fun startTime() {
        CoroutineScope(IO).launch {
            stateOfChronometer = true

            withContext(Main) {
                _finished.value = stateOfChronometer
            }

            var i = 0
            do {
                _seconds.postValue(++i)
                Thread.sleep(1000)
            } while (stateOfChronometer)
        }
    }

    fun pauseTime() {
        stateOfChronometer = false
        _finished.value = stateOfChronometer
        _seconds.value = 0
    }
}