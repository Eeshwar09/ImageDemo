package com.imagedemo.viewmodel

import androidx.lifecycle.ViewModel
import com.imagedemo.IUnSplash
import com.imagedemo.helper.processRequest
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class UnSplashViewModel(private val unSplashService: IUnSplash) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPhotos() {
        compositeDisposable.add(unSplashService.getPhotos()
            .processRequest(
                {

                }, { err ->
                    Timber.d(err)
                }
            ))
    }
}