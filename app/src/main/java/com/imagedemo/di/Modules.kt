package com.example.samplelibrary.koindi

import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidhelpers.SharedPreferenceProvider
import com.imagedemo.database.UnSplashDatabase
import com.imagedemo.viewmodel.UnSplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule =
    module(override = true) {
        single<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }

        single {
            Room.databaseBuilder(androidContext(), UnSplashDatabase::class.java, "un_splash-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        single {
            get<UnSplashDatabase>().unSplashDao()
        }

        viewModel { UnSplashViewModel(unSplashService = get(), unSplashDao = get()) }
    }
