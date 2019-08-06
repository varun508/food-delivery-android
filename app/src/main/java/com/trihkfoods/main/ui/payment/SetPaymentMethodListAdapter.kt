package com.trihkfoods.main.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemSavedPaymentMethodDualLineBinding
import com.trihkfoods.main.databinding.ListItemSavedPaymentMethodSingleLineBinding

class SetPaymentMethodListAdapter(private val items: List<Any>) {


    class ViewHolderSingleLine private constructor(binding: ListItemSavedPaymentMethodSingleLineBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderSingleLine {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemSavedPaymentMethodSingleLineBinding.inflate(inflater, parent, false)
                return ViewHolderSingleLine(binding)
            }
        }

    }

    class ViewHolderDualLine private constructor(binding: ListItemSavedPaymentMethodDualLineBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderDualLine {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemSavedPaymentMethodDualLineBinding.inflate(inflater, parent, false)
                return ViewHolderDualLine(binding)
            }
        }

    }

}