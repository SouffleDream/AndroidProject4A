package com.esiea.androidproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
        val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    } //by me

    fun onClickedIncrement() {
        counter.value = (counter.value ?: 0) + 1
    }
}