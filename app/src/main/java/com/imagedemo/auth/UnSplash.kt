package com.imagedemo.auth

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object UnSplash {
    const val UNSPLASH_AUTH_URL = "https://unsplash.com/oauth/"
    const val CLIENT_ID = "Client-ID EsTlpekTlDYiLCsoHvQkzpXQ9ZkvvSLAHRZGF3qOzp0"
    const val redirectHost = "com.imagedemo"
    const val REDIRECT_URI = "https://$redirectHost/redirect"
    const val RESPONSE_TYPE = "code"
    const val SCOPE = "public+write_likes"
    const val authorize_url = "https://unsplash.com/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=$SCOPE&response_type=$RESPONSE_TYPE"
}

interface UnSplashAuthService{

}