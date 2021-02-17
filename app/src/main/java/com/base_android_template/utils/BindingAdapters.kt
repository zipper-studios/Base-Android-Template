package com.base_android_template.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }
}