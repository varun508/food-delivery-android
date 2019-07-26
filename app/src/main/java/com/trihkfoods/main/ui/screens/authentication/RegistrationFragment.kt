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
import com.trihkfoods.main.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private val viewModel by lazy { ViewModelProviders.of(requireActivity())[AuthenticationViewModel::class.java] }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistrationBinding>(
            inflater,
            R.layout.fragment_registration,
            container,
            false
        ).apply {
            viewModel = this@RegistrationFragment.viewModel
        }

        return binding.root
    }
}