package com.sepack.basic

import android.app.Application
import com.sepack.basic.module.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                MainModule.provideSource(),
                MainModule.provideRepository(),
                MainModule.provideViewModel()
            )
        }
    }
}