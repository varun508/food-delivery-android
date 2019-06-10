package com.trihkfoods.main.utils

import android.animation.AnimatorInflater
import android.content.Context
import android.view.MotionEvent
import android.view.View
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.eventlisteners.ViewBoundTouchEventListener


fun View.scaleOnPress() {

    val scaleDown = AnimatorInflater.loadAnimator(context.applicationContext, R.animator.scale_down)?.apply {
        setTarget(this@scaleOnPress)
    }

    val scaleUp = AnimatorInflater.loadAnimator(context.applicationContext, R.animator.scale_normal)?.apply {
        setTarget(this@scaleOnPress)
    }

    setOnTouchListener(object : ViewBoundTouchEventListener() {
        override fun touchCancel() {
            scaleUp?.start()
        }

        override fun touchDown() {
            scaleDown?.start()
        }

        override fun touchUp() {
            if (scaleDown?.isRunning == true)
                scaleDown.pause()
            performClick()
            scaleDown?.resume()
            scaleUp?.start()
        }
    })
}

fun View.onClick(block: () -> Unit) {
    setOnClickListener { block() }
}