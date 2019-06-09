package com.trihkfoods.main.ui.widgets.viewpager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.widgets.viewpager.adapterdata.GetStartedItem
import java.lang.Exception

class GetStartedPagerAdapter(context: Context, private val items: Array<GetStartedItem>) : PagerAdapter() {

    private val mLayoutInflater = LayoutInflater.from(context)

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return try {
            view == obj as FrameLayout
        } catch (e: Exception) {
            false
        }
    }

    override fun getCount() = items.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val resourceToInflate = R.layout.layout_get_started_slide_item
        val view = mLayoutInflater.inflate(resourceToInflate, container, false)

        val backgroundImageView = view.findViewById<ImageView>(R.id.imageViewSlideItemLgs)
        val image = items[position].backgroundImage

        // Using picasso to load and cache the image for the next use
        Picasso.get().load(image).into(backgroundImageView)

        container.addView(view)
        return view
    }
}