package com.trihkfoods.main.ui.main.explore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ListItemDishHorizontalBinding
import com.trihkfoods.main.tempmodels.FoodItem
import com.trihkfoods.main.utils.onClick

class ExploreDishListAdapter(private val items: List<Any>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == R.layout.list_item_dish_horizontal) ViewHolderFoodItem.from(parent)
        else ViewHolderChefHeader.from(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        if (holder is ViewHolderFoodItem) holder.bind(item as FoodItem)
    }

    override fun getItemViewType(position: Int) =
        if (items[position] is FoodItem) R.layout.list_item_dish_horizontal
        else R.layout.list_item_chef_header

    class ViewHolderFoodItem private constructor(val binding: ListItemDishHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemDishHorizontalBinding.inflate(inflater, parent, false)
                return ViewHolderFoodItem(binding)
            }
        }

        fun bind(dish: FoodItem) {
            binding.run {
                this.dish = dish
                itemCounterDishHorizontal.doOnDecrement {
                    if (it == 0) {
                        tvAddToCartDishHorizontal.visibility = View.VISIBLE
                        itemCounterDishHorizontal.visibility = View.GONE
                    }
                }

                itemCounterDishHorizontal.doOnIncrement {

                }
                tvAddToCartDishHorizontal.onClick {
                    tvAddToCartDishHorizontal.visibility = View.GONE
                    itemCounterDishHorizontal.visibility = View.VISIBLE
                }
            }
        }
    }

    class ViewHolderChefHeader private constructor(val binding: ListItemDishHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolderChefHeader {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.list_item_chef_header, parent, false)
                return ViewHolderChefHeader(view)
            }
        }
    }


}