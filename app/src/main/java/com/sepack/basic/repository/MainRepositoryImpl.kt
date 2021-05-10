package com.sepack.basic.repository

import com.sepack.basic.source.Source
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainRepositoryImpl(private val source: Source) : MainRepository {

    private val _hello: MutableStateFlow<Result<String>> = MutableStateFlow(Result.success(""))

    override val hello: Flow<Result<String>>
        get() = _hello

    override suspend fun getHello() {
        val sourceValue = source.hello()
        _hello.value = Result.success(sourceValue)
    }
}