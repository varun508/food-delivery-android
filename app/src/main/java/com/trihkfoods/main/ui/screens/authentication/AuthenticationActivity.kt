package com.trihkfoods.main.ui.screens.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        changeStatusBarColor(R.color.white)
    }
}
