package com.trihkfoods.main.bindings

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.trihkfoods.main.utils.scaleOnPress


@BindingAdapter("scaleOnPress")
fun View.scale(boolean: Boolean) {
    if (boolean) scaleOnPress()
}

@BindingAdapter(value = ["sourceResource", "cornerRadius"], requireAll = false)
fun ImageView.loadImageFromResource(sourceResource: Int?, cornerRadius: Int?) {
    if (cornerRadius != null && cornerRadius > 0) {
        val options =
            RequestOptions().apply { transform(CenterCrop(), RoundedCorners(cornerRadius)) }
        Glide.with(this).load(sourceResource).apply(options).into(this)
    } else {
        Glide.with(this).load(sourceResource).into(this)
    }
}

@BindingAdapter("backgroundCompatTint")
fun View.setBackgroundTint(color: Int) {
    val drawable = DrawableCompat.wrap(background)
    DrawableCompat.setTint(drawable, color)
    background = drawable
}