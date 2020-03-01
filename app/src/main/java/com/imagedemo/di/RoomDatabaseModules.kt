package com.imagedemo.di

import androidx.room.Room
import com.imagedemo.database.UnSplashDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomDatabaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), UnSplashDatabase::class.java, "un_splash-db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<UnSplashDatabase>().unSplashDao()
    }
}
