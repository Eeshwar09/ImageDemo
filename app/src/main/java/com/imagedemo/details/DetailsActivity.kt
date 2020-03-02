package com.imagedemo.details

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.imagedemo.BaseActivity
import com.imagedemo.R
import com.imagedemo.databinding.ItemDetailsBinding
import com.imagedemo.model.UnSplashModel

class DetailsActivity : BaseActivity() {

    private lateinit var dataBinding: ItemDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.item_details)
        val unSplashModel = intent.getSerializableExtra("UnSplash") as UnSplashModel
        dataBinding.unsplashDetails = unSplashModel

        setUpToolBar(unSplashModel = unSplashModel)

    }


}
