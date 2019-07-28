package com.trihkfoods.main.ui.screens.main.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.ui.tempmodels.Offer
import com.trihkfoods.main.databinding.ListItemOffersBinding
import java.util.ArrayList

class OfferListAdapter(private val offers: ArrayList<Offer>) : RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(parent)

    override fun getItemCount() = offers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(offers[position])
    }

    class ViewHolder(private val binding: ListItemOffersBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(offer: Offer) {
            binding.offer = offer
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemOffersBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}