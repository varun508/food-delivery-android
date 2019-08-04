package com.trihkfoods.main.ui.screens.main.explore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemChefBinding
import com.trihkfoods.main.tempmodels.Chef

class ExploreChefListAdapter(private val chefs: ArrayList<Chef>) :
    RecyclerView.Adapter<ExploreChefListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(parent)

    override fun getItemCount() = chefs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chefs[position])
    }

    class ViewHolder(val binding: ListItemChefBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemChefBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(chef: Chef) {
            binding.run {
                this.chef = chef
            }
        }
    }
}