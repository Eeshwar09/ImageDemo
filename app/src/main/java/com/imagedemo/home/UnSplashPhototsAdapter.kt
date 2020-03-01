package com.imagedemo.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imagedemo.databinding.UnSplashRowBinding
import com.imagedemo.model.UnSplashModel

class UnSplashPhototsAdapter : RecyclerView.Adapter<UnSplashPhotoViewHolder>() {

    var items: MutableList<UnSplashModel> = mutableListOf()
    private lateinit var context: Context
    private lateinit var dataBinding: UnSplashRowBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UnSplashPhotoViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        dataBinding = UnSplashRowBinding.inflate(inflater, parent, false)
        return UnSplashPhotoViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: UnSplashPhotoViewHolder, position: Int) {
        holder.bind(context,items[position])
    }
}