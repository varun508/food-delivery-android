package com.trihkfoods.main.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trihkfoods.main.R
import com.trihkfoods.main.utils.changeStatusBarColor

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        changeStatusBarColor(R.color.white)
    }
}
