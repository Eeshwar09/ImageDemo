package com.imagedemo.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.imagedemo.model.UnSplashModel
import com.imagedemo.databinding.UnSplashRowBinding

class UnSplashPhotoViewHolder(private val dataBinding: UnSplashRowBinding) :
    RecyclerView.ViewHolder(dataBinding.root) {

    fun bind(context: Context, model: UnSplashModel) {
        dataBinding.unSplashModel = model
    }
}