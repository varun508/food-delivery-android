package com.trihkfoods.main.ui.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.FragmentPhoneNumberBinding
import com.trihkfoods.main.databinding.FragmentPhoneVerificationBinding

class PhoneVerificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPhoneVerificationBinding>(
            inflater,
            R.layout.fragment_phone_verification,
            container,
            false
        )
        return binding.root
    }
}