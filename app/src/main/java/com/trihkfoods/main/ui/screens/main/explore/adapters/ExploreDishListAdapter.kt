package com.trihkfoods.main.ui.screens.main.explore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemDishBasicBinding
import com.trihkfoods.main.ui.tempmodels.FoodItem

class ExploreDishListAdapter(private val foodItems: ArrayList<FoodItem>) :
    RecyclerView.Adapter<ExploreDishListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(parent)

    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foodItems[position])
    }

    class ViewHolder(val binding: ListItemDishBasicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemDishBasicBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(foodItem: FoodItem) {
            binding.run {
                this.dish = foodItem
            }
        }
    }
}