package com.trihkfoods.main.ui.coupon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ListItemApplyCouponBinding
import com.trihkfoods.main.databinding.ListItemPaymentOfferBinding
import com.trihkfoods.main.tempmodels.Coupon
import com.trihkfoods.main.tempmodels.PaymentOffer

class CouponListAdapter(private val items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            R.layout.list_item_payment_offer -> ViewHolderPaymentOffer.from(parent)
            R.layout.list_item_apply_coupon -> ViewHolderCoupon.from(parent)
            else -> ViewHolderGenericHeader.from(parent)
        }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is ViewHolderPaymentOffer -> holder.bind(item as PaymentOffer)
            is ViewHolderCoupon -> holder.bind(item as Coupon)
            is ViewHolderGenericHeader -> holder.bind(item as String)
        }
    }

    override fun getItemViewType(position: Int) =
        when (items[position]) {
            is PaymentOffer -> R.layout.list_item_payment_offer
            is Coupon -> R.layout.list_item_apply_coupon
            else -> R.layout.list_item_generic_header
        }

    class ViewHolderCoupon private constructor(binding: ListItemApplyCouponBinding) :
        ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderCoupon {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemApplyCouponBinding.inflate(inflater, parent, false)
                return ViewHolderCoupon(binding)
            }
        }

        fun bind(coupon: Coupon) {
        }
    }

    class ViewHolderPaymentOffer private constructor(binding: ListItemPaymentOfferBinding) :
        ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolderPaymentOffer {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemPaymentOfferBinding.inflate(inflater, parent, false)
                return ViewHolderPaymentOffer(binding)
            }
        }

        fun bind(offer: PaymentOffer) {
        }
    }


    class ViewHolderGenericHeader private constructor(itemView: View) : ViewHolder(itemView) {

        private val textView = itemView.findViewById<TextView>(R.id.tvGenericHeader)

        companion object {
            fun from(parent: ViewGroup): ViewHolderGenericHeader {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.list_item_generic_header, parent, false)
                return ViewHolderGenericHeader(view)
            }
        }

        fun bind(text: String) {
            textView.text = text
        }
    }
}