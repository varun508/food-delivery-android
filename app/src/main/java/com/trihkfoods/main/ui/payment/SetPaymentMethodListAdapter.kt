package com.trihkfoods.main.ui.payment

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemSavedPaymentMethodDualLineBinding
import com.trihkfoods.main.databinding.ListItemSavedPaymentMethodSingleLineBinding

class SetPaymentMethodListAdapter {


    class ViewHolderSingleLine private constructor(binding: ListItemSavedPaymentMethodSingleLineBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup) {

            }
        }

    }

    class ViewHolderDualLine private constructor(binding: ListItemSavedPaymentMethodDualLineBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup) {

            }
        }

    }

}