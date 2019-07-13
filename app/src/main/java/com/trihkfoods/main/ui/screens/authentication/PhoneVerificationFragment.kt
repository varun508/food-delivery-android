package com.trihkfoods.main.ui.screens.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.screens.main.MainActivity
import com.trihkfoods.main.utils.navigateFinishing
import com.trihkfoods.main.utils.navigateTo
import com.trihkfoods.main.utils.onClick
import com.trihkfoods.main.utils.scaleOnPress
import kotlinx.android.synthetic.main.fragment_phone_number.*
import kotlinx.android.synthetic.main.fragment_phone_number.tvVerifyPhoneVerification
import kotlinx.android.synthetic.main.fragment_phone_verification.*

class PhoneVerificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_phone_verification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvVerifyPhoneVerification.run {
            scaleOnPress()
            onClick { activity?.navigateFinishing(MainActivity::class.java) }
        }

    }
}