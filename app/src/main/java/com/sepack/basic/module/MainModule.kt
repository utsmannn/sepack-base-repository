package com.sepack.basic.module

import com.sepack.basic.repository.MainRepository
import com.sepack.basic.repository.MainRepositoryImpl
import com.sepack.basic.source.Source
import com.sepack.basic.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {
    fun provideSource() = module {
        single { Source() }
    }

    fun provideRepository() = module {
        single<MainRepository> { MainRepositoryImpl(get()) }
    }

    fun provideViewModel() = module {
        viewModel { MainViewModel(get()) }
    }
}