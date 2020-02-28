package com.imagedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.imagedemo.model.UnSplashModel
import com.imagedemo.viewmodel.ApiResult
import com.imagedemo.viewmodel.UnSplashViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(), ApiResult {

    val unSplashViewModel by viewModel<UnSplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test_api.setOnClickListener{
            unSplashViewModel.getPhotos(this)
        }
    }

    override fun onSuccess(data: Any) {
        // set the data
    }

    override fun onError(error: String?) {
        // show snack bar for error
        Timber.d(error)
    }
}
