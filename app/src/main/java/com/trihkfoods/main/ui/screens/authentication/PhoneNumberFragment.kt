package com.trihkfoods.main.ui.screens.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.FragmentPhoneNumberBinding
import com.trihkfoods.main.utils.debugLog

class PhoneNumberFragment : Fragment() {

    private val viewModel by lazy { ViewModelProviders.of(requireActivity())[AuthenticationViewModel::class.java] }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPhoneNumberBinding>(
            inflater,
            R.layout.fragment_phone_number,
            container,
            false
        ).apply {
            viewModel = this@PhoneNumberFragment.viewModel
        }

        return binding.root
    }
}