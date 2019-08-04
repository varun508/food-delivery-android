package com.trihkfoods.main.ui.location

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        changeStatusBarColor(R.color.white)
    }
}
