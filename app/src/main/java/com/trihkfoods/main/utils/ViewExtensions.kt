package com.trihkfoods.main.utils

import android.animation.AnimatorInflater
import android.content.Context
import android.view.MotionEvent
import android.view.View
import androidx.core.animation.doOnEnd
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.eventlisteners.ViewBoundTouchEventListener


fun View.scaleOnPress() {

    val scaleDown = AnimatorInflater.loadAnimator(context.applicationContext, R.animator.scale_down)?.apply {
        setTarget(this@scaleOnPress)
    }

    val scaleUp = AnimatorInflater.loadAnimator(context.applicationContext, R.animator.scale_normal)?.apply {
        setTarget(this@scaleOnPress)
    }

    val listener = object : ViewBoundTouchEventListener() {
        override fun touchCancel() {
            scaleUp?.start()
        }

        override fun touchDown() {
            scaleDown?.start()
        }

        override fun touchUp() {
            scaleUp?.start()
        }
    }

    setOnTouchListener(listener)
    scaleUp?.doOnEnd { if (listener.mIsWithinView) performClick() }
}

fun View.onClick(block: () -> Unit) {
    setOnClickListener { block() }
}