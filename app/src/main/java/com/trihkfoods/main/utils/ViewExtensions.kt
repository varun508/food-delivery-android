package com.trihkfoods.main.utils

import android.animation.Animator
import android.animation.AnimatorInflater
import android.app.Activity
import android.os.Build
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.trihkfoods.main.R

/**
 * This function helps activity to change the status bar color
 * on API >= 23 (Android Marshmallow). This is an extension function and
 * is only accessible within the activity
 */
fun Activity.changeStatusBarColor(color: Int) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        window?.run {
            // Change the status bar color
            statusBarColor = ContextCompat.getColor(this@changeStatusBarColor, color)
            // Change the status bar icon tint to dark
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
}

fun View.scaleOnPress() {
    setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                AnimatorInflater.loadAnimator(v.context, R.animator.scale_down)?.apply {
                    setTarget(v)
                    start()
                }
                true
            }
            MotionEvent.ACTION_UP -> {
                AnimatorInflater.loadAnimator(v.context, R.animator.scale_normal)?.apply {
                    setTarget(v)
                    start()
                }
                true
            }
            else -> false
        }
    }
}

fun View.onClick(block: () -> Unit) {
    setOnClickListener { block() }
}