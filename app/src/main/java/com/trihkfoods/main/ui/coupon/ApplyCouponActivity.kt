package com.trihkfoods.main.ui.coupon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityApplyCouponBinding
import com.trihkfoods.main.utils.changeStatusBarColor

class ApplyCouponActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityApplyCouponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_coupon)
        changeStatusBarColor(R.color.light_gray)
    }
}
