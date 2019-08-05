package com.trihkfoods.main.ui.coupon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityApplyCouponBinding
import com.trihkfoods.main.tempmodels.AccountOptionHeader
import com.trihkfoods.main.tempmodels.Coupon
import com.trihkfoods.main.tempmodels.PaymentOffer
import com.trihkfoods.main.ui.main.account.AccountOptionListAdapter
import com.trihkfoods.main.utils.changeStatusBarColor
import kotlinx.android.synthetic.main.activity_apply_coupon.*

class ApplyCouponActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityApplyCouponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_coupon)

        changeStatusBarColor(R.color.white)
        inflateDummyCouponList()
    }

    private fun inflateDummyCouponList() {
        val list = mutableListOf<Any>()

        list += "Available Coupons"
        repeat(5) { list += Coupon() }

        list += "Payment Offers"
        repeat(5) { list += PaymentOffer() }

        rvApplyCoupon?.run {
            layoutManager = LinearLayoutManager(this@ApplyCouponActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
            adapter = AccountOptionListAdapter(list)
        }
    }
}
