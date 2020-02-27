package com.imagedemo

import com.imagedemo.model.UnSplashModel
import io.reactivex.Observable
import retrofit2.http.GET

interface IUnSplash {

    @GET("photos")
    fun getPhotos(): Observable<MutableList<UnSplashModel>>
}