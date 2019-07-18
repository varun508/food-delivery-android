package com.trihkfoods.main.ui.screens.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor
import com.trihkfoods.main.utils.debugLog
import com.trihkfoods.main.utils.onClick
import com.trihkfoods.main.utils.scaleOnPress
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private val navController by lazy { findNavController(R.id.navHostFragmentAuth) }
    private var nextDestinationId: Int = R.id.action_phoneNumberFragment_to_registrationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        changeStatusBarColor(R.color.white)
        setupOnContinueClickListener()
        navController.addOnDestinationChangedListener(this)
    }


    private fun setupOnContinueClickListener() {
        tvContinueAuthActivity?.run {
            scaleOnPress()
            onClick { navController.navigate(nextDestinationId) }
        }
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        destination.label?.run { toString() }.let { label ->
            when (label) {
                "PhoneVerificationFragment" -> {
                    tvContinueAuthActivity?.text = "Verify number"
                    nextDestinationId = 0
                }

                "PhoneNumberFragment" -> {
                    tvContinueAuthActivity?.text = "Continue"
                    nextDestinationId = R.id.action_phoneNumberFragment_to_registrationFragment
                }
                else -> {
                    tvContinueAuthActivity?.text = "Continue"
                    nextDestinationId = R.id.action_registrationFragment_to_phoneVerificationFragment
                }
            }
        }
    }
}
