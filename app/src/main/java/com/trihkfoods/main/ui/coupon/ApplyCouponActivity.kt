package com.trihkfoods.main.ui.coupon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor

class ApplyCouponActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_coupon)
        changeStatusBarColor(R.color.light_gray)
    }
}
