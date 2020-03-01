package com.imagedemo

import android.app.Application
import com.example.samplelibrary.koindi.myModule
import com.imagedemo.di.retrofitModule
import com.imagedemo.di.roomDatabaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ImageDemoApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ImageDemoApplication)
            androidLogger()
            modules(listOf(myModule, retrofitModule))
        }
    }
}