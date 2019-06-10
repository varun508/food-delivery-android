package com.trihkfoods.main.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trihkfoods.main.utils.navigateFinishing

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Navigate to the GetStarted activity after all the pre-processing is done
        navigateFinishing(GetStartedActivity::class.java)
    }
}