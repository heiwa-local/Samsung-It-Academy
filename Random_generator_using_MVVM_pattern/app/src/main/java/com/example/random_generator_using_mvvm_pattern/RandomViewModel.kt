package com.example.random_generator_using_mvvm_pattern

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomViewModel:ViewModel() {
    val currentRandomNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun generateRandomNumber() {
        currentRandomNumber.value = (0..50).random()
    }
}