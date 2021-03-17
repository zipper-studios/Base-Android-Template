package com.base_android_template.utils.binding_adapter

import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.base_android_template.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * BindingAdapters class is responsible for making the appropriate framework calls to
 * set values for views directly inside layout.
 *
 */
object BindingAdapters {

    /**
     * Set the adapter on RecyclerView
     *
     * @param recyclerView RecyclerView. The RecyclerView on which the adapter will be set
     * @param adapter RecyclerView.Adapter<RecyclerView.ViewHolder>. The adapter instance from ViewModel that will be set on RecyclerView
     */
    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }

    /**
     * Load image url ito ImageView using Glide
     *
     * @param imageView ImageView. The ImageView that will display the image
     * @param imageUrl String?. The url of the image that will be displayed
     */
    @BindingAdapter("app:loadImage")
    @JvmStatic
    fun bindLoadImageMethod(imageView: ImageView, imageUrl: String?) {
        val options = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()

        Glide.with(imageView.context)
            .asBitmap()
            .placeholder(getDrawable(imageView.context, R.drawable.bg_gray_rounded))
            .error(getDrawable(imageView.context, R.drawable.bg_gray_rounded))
            .load(imageUrl ?: "")
            .apply(options)
            .into(imageView)
    }

    /**
     * Set the RadioGroup.OnCheckedChangeListener on RadioGroup view
     *
     * @param radioGroup RadioGroup. The RadioGroup to which the OnCheckedChangeListener
     * will be attached
     * @param listener RadioGroup.OnCheckedChangeListener. The listener that will be
     * invoked when the checked radio button changed in this group
     */
    @BindingAdapter("app:setRadioGroupListener")
    @JvmStatic
    fun setRadioGroupListener(
        radioGroup: RadioGroup,
        listener: RadioGroup.OnCheckedChangeListener
    ) {
        radioGroup.setOnCheckedChangeListener(listener)
    }
}