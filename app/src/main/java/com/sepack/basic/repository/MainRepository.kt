package com.sepack.basic.repository

import kotlinx.coroutines.flow.Flow

interface MainRepository {
    val hello: Flow<Result<String>>
    suspend fun getHello()
}