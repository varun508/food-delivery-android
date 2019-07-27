package com.trihkfoods.main.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemChefMainBinding
import com.trihkfoods.main.ui.tempmodels.Chef

class MainChefListAdapter(private val chefs: ArrayList<Chef>) :
    RecyclerView.Adapter<MainChefListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun getItemCount() = chefs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chefs[position])
    }

    class ViewHolder(private val binding: ListItemChefMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemChefMainBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(chef: Chef) {
            binding.run {
                this.chef = chef
                rvChefSpecialsMain.layoutManager = LinearLayoutManager(binding.root.context).apply {
                    orientation = LinearLayout.HORIZONTAL
                }
                rvChefSpecialsMain.adapter = MainChefSpecialListAdapter(chef.chefSpecials)
            }
        }
    }
}