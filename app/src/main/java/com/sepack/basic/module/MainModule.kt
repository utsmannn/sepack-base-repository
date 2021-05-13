package com.sepack.basic.module

import com.sepack.basic.repository.MainRepository
import com.sepack.basic.repository.MainRepositoryImpl
import com.sepack.basic.source.Source
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainModule {

    @Provides
    @ViewModelScoped
    fun provideSource(): Source {
        return Source()
    }

    @Provides
    @ViewModelScoped
    fun provideRepository(source: Source): MainRepository {
        return MainRepositoryImpl(source)
    }
}