package com.trihkfoods.main.ui.screens.main.food

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.databinding.ListItemChefExpandableBinding
import com.trihkfoods.main.tempmodels.Chef
import kotlinx.android.synthetic.main.list_item_chef_expandable.view.*

class MainChefListAdapter(private val chefs: ArrayList<Chef>) :
    RecyclerView.Adapter<MainChefListAdapter.ViewHolder>() {

    private var lastExpanded: Int = -1
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(
            parent
        )

    override fun getItemCount() = chefs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chef = chefs[position]

        holder.binding.root.run {
            setOnClickListener {
                if (lastExpanded != -1 && lastExpanded != position && chefs[lastExpanded].expanded) {
                    chefs[lastExpanded].expanded = false
                    notifyItemChanged(lastExpanded)
                }

                chef.expanded = !chef.expanded

                if (chef.expanded) lastExpanded = position

                notifyItemChanged(position)
            }

            rvChefSpecialsMain.setRecycledViewPool(viewPool)
        }
        holder.bind(chef)
    }

    class ViewHolder(val binding: ListItemChefExpandableBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemChefExpandableBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(chef: Chef) {
            binding.run {
                this.chef = chef
                rvChefSpecialsMain.run {
                    layoutManager = LinearLayoutManager(root.context).apply {
                        orientation = LinearLayout.HORIZONTAL
                    }
                    adapter = MainChefSpecialListAdapter(chef.chefSpecials)
                }
            }
        }
    }
}