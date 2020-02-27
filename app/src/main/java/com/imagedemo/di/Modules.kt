package com.example.samplelibrary.koindi

import com.imagedemo.helper.SharedPreferenceProvider
import com.imagedemo.viewmodel.UnSplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule =
    module(override = true) {
        single<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }

        viewModel { UnSplashViewModel(sharedPreferenceProvider = get(), unSplashService = get()) }
    }
