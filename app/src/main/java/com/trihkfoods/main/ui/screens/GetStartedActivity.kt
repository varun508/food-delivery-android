package com.trihkfoods.main.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor

class GetStartedActivity : AppCompatActivity() {

    private val mStatusBarColor = R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        // Change the status bar color to white on API >= 23 (Android Marshmallow)
        changeStatusBarColor(mStatusBarColor)
    }
}
