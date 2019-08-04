package com.trihkfoods.main.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityCartBinding
import com.trihkfoods.main.utils.changeStatusBarColor

class CartActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        changeStatusBarColor(R.color.white)
    }
}
