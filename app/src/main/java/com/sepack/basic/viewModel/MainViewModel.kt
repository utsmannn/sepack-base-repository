package com.sepack.basic.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sepack.basic.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    val hello = mainRepository.hello
        .asLiveData(viewModelScope.coroutineContext)

    fun getHello() = viewModelScope.launch {
        mainRepository.getHello()
    }
}