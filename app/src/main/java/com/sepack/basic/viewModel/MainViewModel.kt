package com.sepack.basic.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sepack.basic.repository.MainRepository
import com.sepack.basic.repository.MainRepositoryImpl
import com.sepack.basic.source.Source
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val source = Source()
    private val mainRepository: MainRepository = MainRepositoryImpl(source)

    val hello = mainRepository.hello
        .asLiveData(viewModelScope.coroutineContext)

    fun getHello() = viewModelScope.launch {
        mainRepository.getHello()
    }
}