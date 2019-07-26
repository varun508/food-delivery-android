package com.trihkfoods.main.ui.eventlisteners

import android.graphics.Rect
import android.view.MotionEvent
import android.view.View


abstract class ViewBoundTouchEventListener : View.OnTouchListener {

    var mIsWithinView: Boolean = false

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mIsWithinView = true
                touchDown()
                return true
            }

            MotionEvent.ACTION_UP -> {
                touchRelease()
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                if (mIsWithinView && !isTouchInsideViewBounds(view, event)) {
                    mIsWithinView = false
                    touchRelease()
                }
                return true
            }

            MotionEvent.ACTION_CANCEL -> {
                touchRelease()
                return true
            }
            else -> return false
        }
    }


    /** This method is called when the finger is lifted up */
    abstract fun touchRelease()

    /** This method is called when the finger is moved outside the bounds of the view */
    private fun touchCancel() {}

    /** This method is called when the view is touched */
    abstract fun touchDown()

    /** This method is called when the touch is released on the view */
    private fun touchUp() {}


    private fun isTouchInsideViewBounds(view: View, event: MotionEvent): Boolean {
        val viewBounds = Rect(
            view.left,
            view.top,
            view.right,
            view.bottom
        )

        return viewBounds.contains(
            view.left + event.x.toInt(),
            view.top + event.y.toInt()
        )
    }
}