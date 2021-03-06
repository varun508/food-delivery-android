package com.trihkfoods.main.utils

import android.animation.Animator
import android.animation.AnimatorInflater
import android.view.View
import androidx.core.animation.doOnEnd
import com.trihkfoods.main.R
import com.trihkfoods.main.listener.AnimationEndListener
import com.trihkfoods.main.listener.ViewBoundTouchEventListener


fun View.scaleOnPress() {

    val scaleDown =
        AnimatorInflater.loadAnimator(context, R.animator.scale_down)
            ?.apply { setTarget(this@scaleOnPress) }

    val scaleUp =
        AnimatorInflater.loadAnimator(context, R.animator.scale_normal)
            ?.apply { setTarget(this@scaleOnPress) }

    val releaseListener = object : AnimationEndListener {
        override fun onAnimationEnd(p0: Animator?) {
            scaleUp?.start()
            scaleDown?.removeListener(this)
        }
    }

    val listener = object : ViewBoundTouchEventListener() {

        override fun touchCancel() {
            if (scaleDown?.isRunning == true)
                scaleDown.addListener(releaseListener)
            else scaleUp?.start()
        }

        override fun touchUp() {
            if (scaleDown?.isRunning == true)
                scaleDown.addListener(releaseListener)
            else scaleUp?.start()
        }

        override fun touchDown() {
            scaleDown?.start()
        }
    }

    setOnTouchListener(listener)
    scaleUp?.doOnEnd { if (listener.mIsWithinView) performClick() }
}

fun View.onClick(block: () -> Unit) {
    setOnClickListener { block() }
}