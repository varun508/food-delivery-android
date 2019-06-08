package com.trihkfoods.main.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat

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