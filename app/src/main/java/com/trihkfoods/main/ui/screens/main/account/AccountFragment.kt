package com.trihkfoods.main.ui.screens.main.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trihkfoods.main.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }
}