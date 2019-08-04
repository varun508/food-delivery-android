package com.trihkfoods.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.navigateFinishing

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Navigate to the GetStarted activity after all the pre-processing is done
        navigateFinishing(GetStartedActivity::class.java)
    }
}