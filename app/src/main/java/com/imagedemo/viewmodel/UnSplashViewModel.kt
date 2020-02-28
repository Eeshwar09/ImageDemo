package com.imagedemo.viewmodel

import androidx.lifecycle.ViewModel
import com.androidhelpers.SharedPreferenceProvider
import com.imagedemo.helpers.processRequest
import com.imagedemo.netwrok.IUnSplash
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class UnSplashViewModel(
    private val unSplashService: IUnSplash,
    private val sharedPreferenceProvider: SharedPreferenceProvider
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPhotos(callback : ApiResult) {
        compositeDisposable.add(unSplashService.getPhotos()
            .processRequest(
                {
                    callback.onSuccess(it)
                }, { err ->
                    Timber.d(err)
                    callback.onError(err)
                }
            ))
    }
}

interface ApiResult {
    fun onSuccess(data: Any)
    fun onError(error: String?)
}