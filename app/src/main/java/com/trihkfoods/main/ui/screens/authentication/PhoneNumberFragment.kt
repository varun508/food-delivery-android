package com.trihkfoods.main.ui.screens.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.onClick
import com.trihkfoods.main.utils.scaleOnPress
import kotlinx.android.synthetic.main.fragment_phone_number.*

class PhoneNumberFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_phone_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvContinueFpn.scaleOnPress()
        tvContinueFpn.onClick {
            findNavController().navigate(R.id.action_phoneNumberFragment_to_phoneVerificationFragment)
        }
    }
}