package com.trihkfoods.main.utils

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.reflect.KClass

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

fun Activity.navigateTo(cls: Class<out AppCompatActivity>) {
    startActivity(Intent(this, cls))
}

fun Activity.navigateTo(intent: Intent) {
    startActivity(intent)
}

fun Activity.navigateFinishing(cls: Class<out AppCompatActivity>) {
    startActivity(Intent(this, cls)).also { finish() }
}

fun Activity.navigateFinishing(intent: Intent) {
    startActivity(intent).also { finish() }
}