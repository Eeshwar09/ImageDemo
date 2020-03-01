package com.imagedemo.viewmodel

import androidx.lifecycle.ViewModel
import com.imagedemo.database.dao.UnSplashDao
import com.imagedemo.helpers.processRequest
import com.imagedemo.model.UnSplashModel
import com.imagedemo.netwrok.IUnSplash
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class UnSplashViewModel(
    private val unSplashService: IUnSplash,
    private val unSplashDao: UnSplashDao
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPhotos(callback: ApiResult) {
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

    fun saveAll(unSplashList: List<UnSplashModel>?) = unSplashDao.insertAll(unSplashList)

    fun save(unSplash : UnSplashModel) = unSplashDao.insert(unSplash)

    fun getAllDataFromDatabase(): List<UnSplashModel> = unSplashDao.getAll()

}

interface ApiResult {
    fun onSuccess(data: Any?)
    fun onError(error: String?)
}