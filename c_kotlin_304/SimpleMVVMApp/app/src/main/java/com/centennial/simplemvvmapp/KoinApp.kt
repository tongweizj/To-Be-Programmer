package com.centennial.simplemvvmapp

import android.app.Application
import com.centennial.simplemvvmapp.di.appModules
import org.koin.core.context.startKoin

class KoinApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}