package com.imagedemo.netwrok

import com.imagedemo.model.LikePhotoModel
import com.imagedemo.model.UnSplashModel
import io.reactivex.Observable
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface IUnSplash {

    @Headers("Authorization:Client-ID EsTlpekTlDYiLCsoHvQkzpXQ9ZkvvSLAHRZGF3qOzp0")
    @GET("photos")
    fun getPhotos(): Observable<MutableList<UnSplashModel>>


    @POST("photos/:{photoId}/like")
    fun likePhoto(photoId : String) : Observable<LikePhotoModel>

    @DELETE("photos/:{photoId}/like")
    fun unLikePhoto(photoId: String): Observable<LikePhotoModel>


}