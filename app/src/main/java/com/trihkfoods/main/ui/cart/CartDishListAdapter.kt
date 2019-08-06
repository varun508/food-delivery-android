package com.trihkfoods.main.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemCartDishBinding
import com.trihkfoods.main.tempmodels.FoodItem

class CartDishListAdapter(private val dishes: List<FoodItem>) :
    RecyclerView.Adapter<CartDishListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun getItemCount() = dishes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dishes[position])
    }

    class ViewHolder private constructor(private val binding: ListItemCartDishBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemCartDishBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(dish: FoodItem) {
            binding.root.run {
            }
        }
    }
}