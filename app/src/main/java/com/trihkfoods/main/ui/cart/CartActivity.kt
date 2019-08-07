package com.trihkfoods.main.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityCartBinding
import com.trihkfoods.main.tempmodels.Chef
import com.trihkfoods.main.tempmodels.Coupon
import com.trihkfoods.main.tempmodels.FoodItem
import com.trihkfoods.main.ui.coupon.ApplyCouponActivity
import com.trihkfoods.main.ui.payment.SetPaymentMethodActivity
import com.trihkfoods.main.utils.changeStatusBarColor
import com.trihkfoods.main.utils.navigateTo
import com.trihkfoods.main.utils.onClick
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.layout_snippet_activity_cart_bottom.*

class CartActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        changeStatusBarColor(R.color.white)

        inflateDummyCartList()

        tvProceedToPay.onClick { navigateTo(SetPaymentMethodActivity::class.java) }
        include2.onClick { navigateTo(ApplyCouponActivity::class.java) }
    }

    private fun inflateDummyCartList() {

        val chefs = mutableListOf<Chef>()
        repeat(2) {
            val dishes = listOf(FoodItem(), FoodItem())
            chefs += Chef(chefSpecials = dishes)
        }
        rvCartChef.adapter = CartChefListAdapter(chefs)
        rvCartChef.layoutManager =
            LinearLayoutManager(this).apply { orientation = RecyclerView.VERTICAL }
    }
}
