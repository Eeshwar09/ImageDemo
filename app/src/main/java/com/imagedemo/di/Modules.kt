package com.example.samplelibrary.koindi

import com.imagedemo.helper.SharedPreferenceProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule =
    module(override = true) {
        single<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }

        //viewModel { TestViewModel(get()) }
    }
