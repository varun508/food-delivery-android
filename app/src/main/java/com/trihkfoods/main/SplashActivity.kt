package com.trihkfoods.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // navigate to the main activity after all the pre-processing is done
        startActivity(Intent(this,MainActivity::class.java))
    }
}