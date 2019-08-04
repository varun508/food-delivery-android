package com.trihkfoods.main.ui.main.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ListItemAccountOptionBinding
import com.trihkfoods.main.databinding.ListItemAccountOptionHeaderBinding
import com.trihkfoods.main.tempmodels.AccountOption
import com.trihkfoods.main.tempmodels.AccountOptionHeader

class AccountOptionListAdapter(private val list: List<Any>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == R.layout.list_item_account_option) ViewHolderOption.from(
            parent
        )
        else ViewHolderHeader.from(
            parent
        )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is ViewHolderHeader -> holder.bind(item as AccountOptionHeader)
            is ViewHolderOption -> holder.bind(item as AccountOption)
        }
    }

    override fun getItemViewType(position: Int) =
        if (list[position] is AccountOption) R.layout.list_item_account_option
        else R.layout.list_item_account_option_header


    class ViewHolderHeader(private val binding: ListItemAccountOptionHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemAccountOptionHeaderBinding.inflate(inflater, parent, false)
                return ViewHolderHeader(
                    binding
                )
            }
        }

        fun bind(header: AccountOptionHeader) {

        }
    }

    class ViewHolderOption(private val binding: ListItemAccountOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemAccountOptionBinding.inflate(inflater, parent, false)
                return ViewHolderOption(
                    binding
                )
            }
        }

        fun bind(option: AccountOption) {

        }
    }
}