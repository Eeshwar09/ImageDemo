package com.imagedemo.di

import android.content.Context
import androidx.room.Room
import com.imagedemo.database.UnSplashDatabase
import org.koin.dsl.module

val roomDatabaseModule = module {
//    single {
//        unSplashDatabase(get())
//    }
}

//fun unSplashDatabase(context: Context): UnSplashDatabase {
//    return Room.databaseBuilder(context, UnSplashDatabase::class.java, "un_splash-db")
//        .fallbackToDestructiveMigration()
//        .allowMainThreadQueries()
//        .build()
//}