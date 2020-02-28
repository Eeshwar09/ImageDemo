package com.imagedemo.netwrok

import com.imagedemo.model.UnSplashModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface IUnSplash {

    @Headers("Authorization:Client-ID EsTlpekTlDYiLCsoHvQkzpXQ9ZkvvSLAHRZGF3qOzp0")
    @GET("photos")
    fun getPhotos(): Observable<MutableList<UnSplashModel>>



}