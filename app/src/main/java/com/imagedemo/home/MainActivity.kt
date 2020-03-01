package com.imagedemo.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.imagedemo.R
import com.imagedemo.helpers.NetworkHelper
import com.imagedemo.model.UnSplashModel
import com.imagedemo.viewmodel.ApiResult
import com.imagedemo.viewmodel.UnSplashViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ApiResult {

    val unSplashViewModel by viewModel<UnSplashViewModel>()
    private val unSplashPhototsAdapter: UnSplashPhototsAdapter by lazy { UnSplashPhototsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unsplash_photos_recycler_view.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
        unsplash_photos_recycler_view.setHasFixedSize(true)
        unsplash_photos_recycler_view.adapter = unSplashPhototsAdapter

        when {
            NetworkHelper.isNetworkConnected(this) -> unSplashViewModel.getPhotos(this)
            else -> {
                Toast.makeText(this, "No Internet!", Toast.LENGTH_SHORT).show()
                setAdapter(unSplashViewModel.getAllDataFromDatabase())
            }
        }
    }

    override fun onSuccess(data: Any?) {
        for (unSplash in data as MutableList<UnSplashModel>) {
            try {
                unSplashViewModel.save(unSplash)
            } catch (e: Exception) {
                Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
        setAdapter(unSplashViewModel.getAllDataFromDatabase())
    }

    private fun setAdapter(unSplashList: MutableList<UnSplashModel>) {
        unSplashPhototsAdapter.items = unSplashList
        unSplashPhototsAdapter.notifyDataSetChanged()
    }

    override fun onError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        unSplashViewModel.dispose()
    }
}
