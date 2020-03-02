package com.imagedemo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.imagedemo.model.UnSplashModel

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setUpToolBar(unSplashModel: UnSplashModel?) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val heading = toolbar.findViewById<TextView>(R.id.heading)
        val image = toolbar.findViewById<ImageView>(R.id.toolbarImageIcon)
        if (unSplashModel!=null){
            heading.text = unSplashModel.user?.name
            Glide.with(this).load(unSplashModel.user?.profile_image?.medium).circleCrop()
                .placeholder(R.mipmap.ic_launcher_round).into(image)
        }else{
            heading.text = "Home"
            Glide.with(this).load(R.mipmap.ic_launcher_round).circleCrop()
                .placeholder(R.mipmap.ic_launcher_round).into(image)
        }

    }
}