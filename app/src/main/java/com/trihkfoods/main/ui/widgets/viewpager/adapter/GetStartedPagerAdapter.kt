package com.trihkfoods.main.ui.widgets.viewpager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.trihkfoods.main.R
import java.lang.Exception

class GetStartedPagerAdapter(context: Context, private val images: Array<Int>) : PagerAdapter() {

    private val mLayoutInflater = LayoutInflater.from(context)

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return try {
            view == obj as FrameLayout
        } catch (e: Exception) {
            false
        }
    }

    override fun getCount() = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val resourceToInflate = R.layout.layout_get_started_slide_item
        val view = mLayoutInflater.inflate(resourceToInflate, container, false)

        val backgroundImageView = view.findViewById<ImageView>(R.id.imageViewSlideItemLgs)

        // Using picasso to load and cache the image for the next use
        Glide.with(backgroundImageView.context).load(images[position]).into(backgroundImageView)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as FrameLayout)
    }
}