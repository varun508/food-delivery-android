package com.trihkfoods.main.ui.main.explore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemDishHorizontalBinding
import com.trihkfoods.main.tempmodels.FoodItem
import com.trihkfoods.main.utils.onClick
import kotlinx.android.synthetic.main.list_item_dish_horizontal.view.*

class ExploreDishListAdapter(private val foodItems: ArrayList<FoodItem>) :
    RecyclerView.Adapter<ExploreDishListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foodItems[position])
    }

    class ViewHolder(val binding: ListItemDishHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemDishHorizontalBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
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
}