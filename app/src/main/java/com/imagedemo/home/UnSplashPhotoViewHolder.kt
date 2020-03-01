package com.imagedemo.home

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.imagedemo.databinding.UnSplashRowBinding
import com.imagedemo.details.DetailsActivity
import com.imagedemo.model.UnSplashModel

class UnSplashPhotoViewHolder(private val dataBinding: UnSplashRowBinding) :
    RecyclerView.ViewHolder(dataBinding.root) {

    fun bind(context: Context, model: UnSplashModel) {
        dataBinding.unSplashModel = model

        itemView.setOnClickListener {
            context.startActivity(
                Intent(context, DetailsActivity::class.java).putExtra(
                    "UnSplash",
                    model
                )
            )
        }
    }
}