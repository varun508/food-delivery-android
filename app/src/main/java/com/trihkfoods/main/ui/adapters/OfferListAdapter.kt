package com.trihkfoods.main.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class OfferListAdapter : RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun getItemCount(): Int {
        return 0;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


    /** Will change @param itemView to the binding */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}