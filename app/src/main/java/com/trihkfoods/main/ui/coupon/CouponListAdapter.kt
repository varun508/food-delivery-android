package com.trihkfoods.main.ui.coupon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ListItemApplyCouponBinding

class CouponListAdapter(private val items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == R.layout.list_item_generic_header) ViewHolderGenericHeader.from(parent)
        else ViewHolderCoupon.from(parent)


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        if(holder is ViewHolderCoupon)
            holder.bind(item as )
    }

    override fun getItemViewType(position: Int) =
        if (items[position] is String) R.layout.list_item_generic_header
        else R.layout.list_item_apply_coupon

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


    class ViewHolderGenericHeader(itemView: View) : ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup): ViewHolderGenericHeader {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.list_item_generic_header, parent, false)
                return ViewHolderGenericHeader(view)
            }
        }

        fun bind(text: String) {

        }
    }
}