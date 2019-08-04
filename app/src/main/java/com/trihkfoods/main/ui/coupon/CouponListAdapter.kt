package com.trihkfoods.main.ui.coupon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trihkfoods.main.databinding.ListItemApplyCouponBinding

class CouponListAdapter(private val items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolderCoupon(binding: ListItemApplyCouponBinding) :
        ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderCoupon {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemApplyCouponBinding.inflate(inflater, parent, false)
                return ViewHolderCoupon(binding)
            }
        }

        fun bind() {

        }
    }


    class ViewHolderGenericHeader(itemView: View) :
        ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup) {

            }
        }

        fun bind() {

        }
    }
}