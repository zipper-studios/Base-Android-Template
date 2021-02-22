package com.base_android_template.utils.binding_adapter

import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.base_android_template.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }

    @BindingAdapter("app:loadImage")
    @JvmStatic
    fun bindLoadImageMethod(imageView: ImageView, data: String?) {
        val options = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()

        Glide.with(imageView.context)
            .asBitmap()
            .placeholder(getDrawable(imageView.context, R.drawable.bg_gray_rounded))
            .error(getDrawable(imageView.context, R.drawable.bg_gray_rounded))
            .load(data ?: "")
            .apply(options)
            .into(imageView)
    }
}