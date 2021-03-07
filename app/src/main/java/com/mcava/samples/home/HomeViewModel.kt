package com.mcava.samples.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcava.samples.domain.SampleUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val sampleUseCase: SampleUseCase
) : ViewModel() {


    fun doSomething() {
        viewModelScope.launch {
            val a = sampleUseCase()
            Log.d(this@HomeViewModel.javaClass.simpleName, a)
        }
    }


}