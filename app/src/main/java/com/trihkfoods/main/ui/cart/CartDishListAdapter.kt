package com.trihkfoods.main.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemCartDishBinding

class CartDishListAdapter : RecyclerView.Adapter<CartDishListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun getItemCount(): Int {
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


    class ViewHolder(binding: ListItemCartDishBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemCartDishBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}