package com.trihkfoods.main.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemCartChefBinding
import com.trihkfoods.main.tempmodels.Chef
import kotlinx.android.synthetic.main.list_item_cart_chef.view.*

class CartChefListAdapter(private val chefs: List<Chef>) :
    RecyclerView.Adapter<CartChefListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun getItemCount() = chefs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chefs[position])
    }

    class ViewHolder private constructor(private val binding: ListItemCartChefBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemCartChefBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(chef: Chef) {
            binding.root.run {
            }
        }
    }
}