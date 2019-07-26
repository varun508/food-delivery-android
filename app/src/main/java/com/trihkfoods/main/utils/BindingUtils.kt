package com.trihkfoods.main.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("sourceUrl")
fun ImageView.loadImageFromUrl(url: String?) {

    url?.let {
        val options = RequestOptions().apply {
            transform(CenterCrop(), RoundedCorners(16))
        }
        Glide.with(this).load(it).apply(options).into(this)
    }
}

@BindingAdapter("scaleOnPress")
fun View.scaleOnPress(boolean: Boolean) {
    if (boolean) scaleOnPress()
}