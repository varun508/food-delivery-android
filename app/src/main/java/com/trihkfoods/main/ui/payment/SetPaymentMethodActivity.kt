package com.trihkfoods.main.ui.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivitySetPaymentMethodBinding
import com.trihkfoods.main.utils.changeStatusBarColor

class SetPaymentMethodActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySetPaymentMethodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_set_payment_method)

        changeStatusBarColor(R.color.white)
    }
}
