package com.imagedemo.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.imagedemo.R


@BindingAdapter("android:src")
fun setImageUrl(view: ImageView, url: String) {
    when (view.id) {
        R.id.imageIcon -> {
            Glide.with(view.context).load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(view)
        }
        R.id.toolbarImageIcon -> {
            Glide.with(view.context).load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .circleCrop()
                .into(view)
        }
        else -> {
            Glide.with(view.context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(view)
        }
    }

}

@BindingAdapter("android:src")
fun setImageResource(view: ImageView, src: Int) {
    Glide.with(view.context).load(src).into(view)
}