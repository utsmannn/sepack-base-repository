package com.sepack.basic.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sepack.basic.repository.MainRepository
import com.sepack.basic.repository.MainRepositoryImpl
import com.sepack.basic.source.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    val hello = mainRepository.hello
        .asLiveData(viewModelScope.coroutineContext)

    fun getHello() = viewModelScope.launch {
        mainRepository.getHello()
    }
}