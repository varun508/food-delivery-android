package com.trihkfoods.main.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.ui.tempmodels.FoodItem

class MainChefSpecialListAdapter(private val items: List<FoodItem>) :
    RecyclerView.Adapter<MainChefSpecialListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun getItemCount(): Int {
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        companion object{

            fun from(parent: ViewGroup){
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.)
            }
        }
    }
}