package com.trihkfoods.main.ui

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.adapters.GetStartedPagerAdapter
import com.trihkfoods.main.databinding.ActivityGetStartedBinding
import com.trihkfoods.main.listener.BasePageChangeListener
import com.trihkfoods.main.ui.authentication.AuthenticationActivity
import com.trihkfoods.main.utils.navigateTo
import com.trihkfoods.main.utils.onClick
import com.trihkfoods.main.utils.scaleOnPress
import kotlinx.android.synthetic.main.activity_get_started.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


class GetStartedActivity : AppCompatActivity(), BasePageChangeListener, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val mViewPagerImages = arrayOf(
        R.drawable.image_temp_getting_started_1,
        R.drawable.image_temp_getting_started_2,
        R.drawable.image_temp_getting_started_3
    )

    private val mPageTitles by lazy {
        arrayOf(
            getString(R.string.get_started_title_text_1),
            getString(R.string.get_started_title_text_2),
            getString(R.string.get_started_title_text_3)
        )
    }

    private val mPageBodyText by lazy {
        arrayOf(
            getString(R.string.get_started_body_text_1),
            getString(R.string.get_started_body_text_2),
            getString(R.string.get_started_body_text_3)
        )
    }

    private val mDotViews by lazy {
        arrayOf(
            TextView(this@GetStartedActivity),
            TextView(this@GetStartedActivity),
            TextView(this@GetStartedActivity)
        )
    }

    private val mColorWhite by lazy {
        ContextCompat.getColor(
            this@GetStartedActivity,
            R.color.white
        )
    }
    private val mColorAlphaWhite by lazy {
        ContextCompat.getColor(
            this@GetStartedActivity,
            R.color.white_50
        )
    }


    private lateinit var _binding: ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_get_started)

        setupViewPager()
        addDotIndicator()
        onPageSelected(0)
        setupClickEvents()
    }

    private fun setupViewPager() {
        autoSlidingViewPagerAgs?.run {
            adapter = GetStartedPagerAdapter(
                this@GetStartedActivity,
                mViewPagerImages
            )
            setupAutoPageTransition()
        }
    }

    private fun addDotIndicator() {
        mDotViews.apply {
            forEach {
                createDot(it)
                dotLayoutAgs.addView(it)
            }
        }
    }

    private fun createDot(view: TextView) {
        view.run {
            text = getHtmlText()
            textSize = 35f
            setTextColor(mColorWhite)
        }
    }


    @Suppress("DEPRECATION")
    private fun getHtmlText() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml("&#8226;")


    private fun selectDot(position: Int) {
        mDotViews.forEachIndexed { index, textView ->
            textView.setTextColor(if (index == position) mColorWhite else mColorAlphaWhite)
        }
    }

    private fun setupClickEvents() {
        tvSignInAgs?.run {
            scaleOnPress()
            onClick { navigateTo(AuthenticationActivity::class.java) }
        }
    }

    override fun onPageSelected(position: Int) {
        textSwitcherBodyAgs.setText(mPageBodyText[position])
        textSwitcherTitleAgs.setText(mPageTitles[position])
        selectDot(position)
    }

    override fun onStop() {
        super.onStop()
        autoSlidingViewPagerAgs?.removeOnPageChangeListener(this)
    }

    override fun onStart() {
        super.onStart()
        autoSlidingViewPagerAgs?.addOnPageChangeListener(this)
    }
}
