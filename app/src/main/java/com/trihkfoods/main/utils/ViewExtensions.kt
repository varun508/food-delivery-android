package com.trihkfoods.main.utils

import android.animation.Animator
import android.animation.AnimatorInflater
import android.view.View
import androidx.core.animation.doOnEnd
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.eventlisteners.AnimationEndListener
import com.trihkfoods.main.ui.eventlisteners.ViewBoundTouchEventListener


fun View.scaleOnPress() {

    val scaleDown =
        AnimatorInflater.loadAnimator(context, R.animator.scale_down)?.apply { setTarget(this@scaleOnPress) }
    val scaleUp =
        AnimatorInflater.loadAnimator(context, R.animator.scale_normal)?.apply { setTarget(this@scaleOnPress) }

    val releaseListener = object : AnimationEndListener {
        override fun onAnimationEnd(p0: Animator?) {
            if (scaleDown?.isRunning == true)
                scaleDown.doOnEnd {
                    scaleUp?.start()
                    it.removeListener(this)
                }
            else scaleUp?.start()
        }
    }

    val listener = object : ViewBoundTouchEventListener() {

        override fun touchDown() {
            scaleDown?.start()
        }

        override fun touchRelease() {
            scaleDown?.addListener(releaseListener)
        }
    }

    setOnTouchListener(listener)
    scaleUp?.doOnEnd { if (listener.mIsWithinView) performClick() }
}

fun View.onClick(block: () -> Unit) {
    setOnClickListener { block() }
}