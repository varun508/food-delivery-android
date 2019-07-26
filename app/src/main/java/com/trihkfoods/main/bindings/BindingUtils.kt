package com.trihkfoods.main.bindings

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.trihkfoods.main.utils.scaleOnPress

private val roundedCornersOptions = RequestOptions().apply {
    transform(CenterCrop(), RoundedCorners(16))
}

@BindingAdapter("sourceUrl")
fun ImageView.loadImageFromUrl(url: String?) {
    Glide.with(this).load(url ?: "").apply(roundedCornersOptions).into(this)
}

@BindingAdapter("scaleOnPress")
fun View.scaleOnPress(boolean: Boolean) {
    if (boolean) scaleOnPress()
}

@BindingAdapter("sourceResource")
fun ImageView.loadImageFromResource(resource: Int) {
    Glide.with(this).load(resource).apply(roundedCornersOptions).into(this)
}