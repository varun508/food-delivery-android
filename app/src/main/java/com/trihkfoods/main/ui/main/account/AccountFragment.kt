package com.trihkfoods.main.ui.main.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.FragmentAccountBinding
import com.trihkfoods.main.tempmodels.AccountOption
import com.trihkfoods.main.tempmodels.AccountOptionHeader
import kotlinx.android.synthetic.main.fragment_account.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inflateDummyOptionList()
    }

    private fun inflateDummyOptionList() {
        val list = mutableListOf<Any>()

        list += AccountOptionHeader(title = "Account Settings", subTitle = "Payments, Addresses and more")
        list += AccountOption("Payment Methods")
        list += AccountOption("Manage Addresses")
        list += AccountOption("Favourites")
        list += AccountOption("Invite")
        list += AccountOption("Past Orders")

        list += AccountOptionHeader(title = "HELP", subTitle = "Issues and FAQs")
        list += AccountOption("TRIHK Deals")
        list += AccountOption("Chat With Us")
        list += AccountOption("General Issues")
        list += AccountOption("FAQs")

        rvAccountOption?.run {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = RecyclerView.VERTICAL
            }
            adapter = AccountOptionListAdapter(list)
        }
    }
}