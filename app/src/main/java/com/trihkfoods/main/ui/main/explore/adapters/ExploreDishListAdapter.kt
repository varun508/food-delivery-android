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

class ExploreDishListAdapter(private val foodItems: List<FoodItem>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foodItems[position])
    }

    class ViewHolderFoodItem(val binding: ListItemDishHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemDishHorizontalBinding.inflate(inflater, parent, false)
                return ViewHolderFoodItem(binding)
            }
        }

        fun bind(foodItem: FoodItem) {
            binding.run {
                this.dish = foodItem
                itemCounterDishHorizontal.doOnDecrement {
                    if(it == 0){
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

    class ViewHolderChefHeader(val binding: ListItemDishHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolderChefHeader {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.list_item_chef_header,parent,false)
                return ViewHolderChefHeader(view)
            }
        }
    }


}