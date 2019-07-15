package com.trihkfoods.main.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("sourceUrl")
fun ImageView.loadImageFromUrl(url: String?) {
    url?.let { Glide.with(this).load(url).into(this) }
}

@BindingAdapter("scaleOnPress")
fun View.scaleOnPress(boolean: Boolean) {
    if (boolean) scaleOnPress()
}