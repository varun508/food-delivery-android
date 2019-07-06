package com.trihkfoods.main.ui.screens

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.eventlisteners.BasePageChangeListener
import com.trihkfoods.main.ui.screens.authentication.AuthenticationActivity
import com.trihkfoods.main.ui.widgets.viewpager.adapter.GetStartedPagerAdapter
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

    private val mViewPagerImages = arrayOf(R.drawable.image_getting_started_1, R.drawable.image_getting_started_2, R.drawable.image_getting_started_3)
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

    private val mColorWhite by lazy { ContextCompat.getColor(this@GetStartedActivity, R.color.white) }
    private val mColorAlphaWhite by lazy { ContextCompat.getColor(this@GetStartedActivity, R.color.white_50) }
    private var mDotViews: Array<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        setupViewPager()
        addDotIndicator()
        onPageSelected(0)
        setupClickEvents()
    }

    private fun setupViewPager() {
        autoSlidingViewPagerAgs?.run {
            adapter = GetStartedPagerAdapter(this@GetStartedActivity, mViewPagerImages)
            setupAutoPageTransition()
        }
    }

    private fun addDotIndicator() {
        mDotViews = arrayOf(TextView(this), TextView(this), TextView(this)).apply {
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

    /**
     * This API was deprecated in Android version N, for api above N the new method is being used
     * and for below the deprecated method is used
     */
    @Suppress("DEPRECATION")
    private fun getHtmlText() =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                Html.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
            else
                Html.fromHtml("&#8226;")


    private fun selectDot(position: Int) {
        mDotViews?.forEachIndexed { index, textView ->
            textView.setTextColor(if (index == position) mColorWhite else mColorAlphaWhite)
        }
    }

    private fun setupClickEvents() {
        tvSignInAgs?.run { onClick { navigateTo(AuthenticationActivity::class.java) } }
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
