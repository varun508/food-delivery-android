package com.trihkfoods.main.ui.widgets.viewpager

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class AutoSlidingViewPager(context: Context) : ViewPager(context) {

    constructor(context: Context, attrs: AttributeSet) : this(context)

    /**
     * Takes in a null reference but attaches it to the viewpager
     * only if it is not null
     */
    override fun setAdapter(adapter: PagerAdapter?) {
        adapter?.run { super.setAdapter(this) }
    }
}