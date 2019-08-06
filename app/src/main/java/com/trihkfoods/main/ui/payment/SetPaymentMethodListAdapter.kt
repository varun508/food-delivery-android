package com.trihkfoods.main.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ListItemSavedPaymentMethodDualLineBinding
import com.trihkfoods.main.databinding.ListItemSavedPaymentMethodSingleLineBinding
import com.trihkfoods.main.tempmodels.Card
import com.trihkfoods.main.tempmodels.Wallet

class SetPaymentMethodListAdapter(private val items: List<Any>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == R.layout.list_item_saved_payment_method_single_line) ViewHolderSingleLine.from(
            parent
        )
        else ViewHolderDualLine.from(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is ViewHolderSingleLine -> holder.bind(item as Wallet)
            is ViewHolderDualLine -> holder.bind(item as Card)
        }
    }


    override fun getItemViewType(position: Int) =
        if (items[position] is Wallet) R.layout.list_item_saved_payment_method_single_line
        else R.layout.list_item_saved_payment_method_dual_line

    class ViewHolderSingleLine private constructor(binding: ListItemSavedPaymentMethodSingleLineBinding) :
        ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderSingleLine {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemSavedPaymentMethodSingleLineBinding.inflate(inflater, parent, false)
                return ViewHolderSingleLine(binding)
            }
        }

        fun bind(wallet: Wallet) {

        }

    }

    class ViewHolderDualLine private constructor(binding: ListItemSavedPaymentMethodDualLineBinding) :
        ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderDualLine {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemSavedPaymentMethodDualLineBinding.inflate(inflater, parent, false)
                return ViewHolderDualLine(binding)
            }
        }

        fun bind(card: Card) {

        }
    }

}