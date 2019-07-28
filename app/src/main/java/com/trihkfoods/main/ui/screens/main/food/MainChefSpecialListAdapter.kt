package com.trihkfoods.main.ui.screens.main.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemChefSpecialMainBinding
import com.trihkfoods.main.ui.tempmodels.FoodItem

class MainChefSpecialListAdapter(private val items: List<FoodItem>) :
    RecyclerView.Adapter<MainChefSpecialListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(
            parent
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: ListItemChefSpecialMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemChefSpecialMainBinding.inflate(inflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

        fun bind(foodItem: FoodItem) {
            binding.foodItem = foodItem
        }
    }
}