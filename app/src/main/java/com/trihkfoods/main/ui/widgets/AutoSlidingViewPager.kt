package com.trihkfoods.main.ui.widgets

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    fun CoroutineScope.setupAutoPageTransition() {
        launch(Dispatchers.Main) {
            while (true) {
                delay(5000)
                val position = (currentItem + 1) % 3
                setCurrentItem(position, true)
            }
        }
    }



}