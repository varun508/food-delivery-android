package com.trihkfoods.main.ui.screens.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)


        changeStatusBarColor(R.color.white)
        findNavController(R.id.navHostFragmentAuth).navigate(R.id.action_phoneNumberFragment_to_registrationFragment)
    }
}
