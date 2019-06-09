package com.trihkfoods.main.ui.widgets.viewpager

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.core.view.size
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class AutoSlidingViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {


    /**
     * Takes in a null adapter reference but attaches it to the viewpager
     * only if it is not null
     */
    override fun setAdapter(adapter: PagerAdapter?) {
        adapter?.run { super.setAdapter(this) }
    }

    /**
     * Changes the current page after the timeout
     */
    fun setupAutoPageTransition(time: Long) {
        postDelayed({
            val item = (currentItem + 1)/3
            setCurrentItem(item, true)
        }, time)
    }
}