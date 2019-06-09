package com.trihkfoods.main.ui.screens.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.widgets.viewpager.adapter.GetStartedPagerAdapter
import kotlinx.android.synthetic.main.activity_get_started.*


class GetStartedActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private val tag = "GetStartedActivity"

    private val images = arrayOf(R.drawable.gs_image_a, R.drawable.gs_image_b, R.drawable.gs_image_c)
    private val titles = arrayOf(
            "Bored of the usual?\nLet's pump it up\nTRIHK it up"
            , "Uncage variety of cuisines and chef specials"
            , "Uncage your hunger for Traditional Recipe Inside Home Kitchen"
    )
    private val mDotViews: Array<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        setupViewPager()
    }

    private fun setupViewPager() {
        autoSlidingViewPagerAgs?.run {
            adapter = GetStartedPagerAdapter(this@GetStartedActivity, images)
            addOnPageChangeListener(this@GetStartedActivity)
        }
    }

    private fun addDotIndicator() {
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        textSwitcherAgs.setText(titles[position])
    }

}
